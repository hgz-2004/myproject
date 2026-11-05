package mobileshop.dao;

import mobileshop.db.DB;
import mobileshop.entity.UserEntity;

public class LoginDao {
    /**
     * 返回 true 表示密码验证正确，返回false表示验证失败
     * @param username 用户发送用户名
     * @param pwd 用户发送密码
     * @return
     */
    public boolean validUserPwd(String username,String pwd){
        UserEntity ue=DB.USERS.get(username);
        if(ue==null){
            return false;
        }
        return ue.getPassword().equals(pwd);
    }
}
