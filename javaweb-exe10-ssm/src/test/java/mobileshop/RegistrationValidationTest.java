package mobileshop;

import mobileshop.controller.RegisterController;
import mobileshop.dao.UserDao;
import mobileshop.entity.UserEntity;
import mobileshop.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class RegistrationValidationTest {
    private StubDao dao;
    private UserServiceImpl service;
    private MockMvc mvc;

    @Before
    public void setup() {
        dao = new StubDao();
        service = new UserServiceImpl();
        ReflectionTestUtils.setField(service, "userDao", dao);
        RegisterController controller = new RegisterController();
        ReflectionTestUtils.setField(controller, "userService", service);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    private void check(String path, String username, String password, String email,
                       String message) throws Exception {
        org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder request = post(path);
        if (username != null) request.param("username", username);
        if (password != null) request.param("password", password);
        if (email != null) request.param("email", email);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertNotNull(result.getModelAndView());
        assertEquals("msg", result.getModelAndView().getViewName());
        assertEquals(message, result.getModelAndView().getModel().get("msg"));
    }

    @Test
    public void rejectsMissingEmptyAndWhitespaceFieldsBeforeQuerying() throws Exception {
        for (String blank : new String[]{null, "", "   "}) {
            check("/signup", blank, "123456", "new@example.com", "用户名，密码，邮箱均不能为空");
            check("/signup", "new", blank, "new@example.com", "用户名，密码，邮箱均不能为空");
            check("/signup", "new", "123456", blank, "用户名，密码，邮箱均不能为空");
        }
        assertEquals(0, dao.queries);
        assertEquals(0, dao.inserts);
    }

    @Test
    public void rejectsExistingUsername() throws Exception {
        check("/signup", "existing", "123456", "new@example.com", "用户名或Email已存在");
        assertEquals(0, dao.inserts);
    }

    @Test
    public void rejectsExistingEmailWithNewUsername() throws Exception {
        check("/signup", "new", "123456", "existing@example.com", "用户名或Email已存在");
        assertEquals(0, dao.inserts);
    }

    @Test
    public void savesNewUser() throws Exception {
        check("/signup", "new", "123456", "new@example.com", "注册成功");
        assertEquals(1, dao.inserts);
        assertEquals("new", dao.saved.getUsername());
        assertEquals("123456", dao.saved.getPassword());
        assertEquals("new@example.com", dao.saved.getEmail());
    }

    @Test
    public void reportsUnsuccessfulSave() throws Exception {
        dao.rows = 0;
        check("/signup", "new", "123456", "new@example.com", "注册失败");
    }

    @Test
    public void legacyRegisterRouteUsesSameValidation() throws Exception {
        check("/register", "new", "123456", "existing@example.com", "用户名或Email已存在");
        check("/register", "", "123456", "new@example.com", "用户名，密码，邮箱均不能为空");
        assertEquals(0, dao.inserts);
    }

    @Test
    public void directServiceCallsCannotBypassValidation() {
        assertFalse(service.save(null));
        UserEntity user = new UserEntity();
        assertFalse(service.save(user));
        user.setUsername("new");
        user.setPassword("123456");
        user.setEmail("existing@example.com");
        assertFalse(service.register(user));
        assertEquals(0, dao.inserts);
    }

    private static class StubDao implements UserDao {
        int queries, inserts;
        int rows = 1;
        UserEntity saved;
        public UserEntity findByUserName(String username) { return null; }
        public boolean existUserNameOrEmail(String username, String email) {
            queries++;
            return "existing".equals(username) || "existing@example.com".equals(email);
        }
        public int save(UserEntity user) {
            inserts++;
            saved = user;
            return rows;
        }
    }
}
