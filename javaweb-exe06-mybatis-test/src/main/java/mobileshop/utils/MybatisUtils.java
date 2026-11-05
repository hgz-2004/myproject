package mobileshop.utils;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
    //获取SqlSession的方法
    public static SqlSession getSqlSession(){
        //SqlSessionFactoryBuilder --> SqlSessionFactory --> SqlSession
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //加载sqlMapConfig.xml
        ClassLoader loader= MybatisUtils.class.getClassLoader();//MybatisUtil：自己写的类都可以
        InputStream inStream=loader.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory=builder.build(inStream);
        SqlSession session=factory.openSession();
        return session;
    }
}
