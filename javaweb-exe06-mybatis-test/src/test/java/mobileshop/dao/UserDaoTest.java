package mobileshop.dao;

import mobileshop.entity.UserEntity;
import mobileshop.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserDaoTest {

    private SqlSession session;
    private UserDao userDao;

    @Before
    public void beforeTest(){
        session=MybatisUtils.getSqlSession();
        userDao=session.getMapper(UserDao.class); //生成的一个动态代理
    }

    @Test
    public void testFindAll(){
        List<UserEntity> list= userDao.findAll();
        assertTrue(list.size()>0);
    }

    @Test
    /**
     * 另一种方法运行findAll
     */
    public void testFindAll2(){
        List<UserEntity> list= session.selectList("findAll");
        assertTrue(list.size()>0);
    }

    @Test
    /**
     * 测试 findByUserName 功能
     */
    public void testFindByUserName(){
        String username="zhangsan";
        UserEntity ue=userDao.findByUserName(username);
        assertEquals(username,ue.getUsername());
    }

    @Test
    /**
     * 另一种方法调用 findByUserName 功能
     */
    public void testFindByUserName2(){
        String username="zhangsan";
        UserEntity ue=session.selectOne("findByUserName",username);
        assertEquals(username,ue.getUsername());
    }

    @Test
    /**
     * 测试 updatePassword 功能
     */
    public void testUpdatePassword(){
        int rs=userDao.updatePassword("zhangsan","123456");
        assertEquals(1,rs);
    }

    @Test
    /**
     * 另一种方法调用 updatePassword 功能
     */
    public void testUpdatePassword2(){
        Map<String,String> map=new HashMap<>();
        map.put("username","zhangsan");
        map.put("password","123456");
        int rs=session.update("updatePassword",map);
        assertEquals(1,rs);
    }

    @Test
    /**
     * 测试 save 功能
     */
    public void testSave(){
        UserEntity u=new UserEntity();
        u.setUsername("lisi");
        u.setPassword("135790");
        int rs=userDao.save(u);
        assertEquals(1,rs);
    }

    @Test
    /**
     * 另一种方法调用 save 功能
     */
    public void testSave2(){
        UserEntity u=new UserEntity();
        u.setUsername("lisi");
        u.setPassword("135790");
        int rs=session.insert("save",u);
        assertEquals(1,rs);
    }

    @Test
    /**
     * 测试 deleteByUsername 功能
     */
    public void testDeleteByUsername(){
        UserEntity u=new UserEntity();
        u.setUsername("wangwu");
        u.setPassword("135790");
        userDao.save(u);
        int rs=userDao.deleteByUsername("wangwu");
        assertEquals(1,rs);
    }

    @Test
    /**
     * 另一种方法调用 deleteByUsername 功能
     */
    public void testDeleteByUsername2(){
        UserEntity u=new UserEntity();
        u.setUsername("wangwu");
        u.setPassword("135790");
        userDao.save(u);
        int rs=session.delete("deleteByUsername","wangwu");
        assertEquals(1,rs);
    }

    @After
    public void closeSession(){
        if(session!=null) {
            session.commit();//提交更改
            session.close();
        }
    }
}