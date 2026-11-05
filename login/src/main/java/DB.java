import java.util.HashMap;
import java.util.Map;

public class DB {
    public static final Map<String,UserEntity> USERS=new HashMap<>();
    static{
        UserEntity ue=new UserEntity();
        ue.setUsername("zhangsan");
        ue.setPassword("123456");
        //在数据库保存用户名和密码
        USERS.put(ue.getUsername(),ue);
    }
}
