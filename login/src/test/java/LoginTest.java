import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void testLoginController(){
        LoginController controller=new LoginController();
        System.out.println(controller.login("zhangsan","123456"));
    }

    @Test
    public void testLoginService(){
        LoginService service=new LoginService();
        UserEntity ue=new UserEntity();
        ue.setUsername("zhangsan");
        ue.setPassword("123456");
        assertTrue(service.validUserPwd(ue));
    }
}
