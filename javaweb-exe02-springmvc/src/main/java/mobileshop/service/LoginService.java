package mobileshop.service;

import mobileshop.dao.LoginDao;
import mobileshop.entity.UserEntity;

public class LoginService {
    private LoginDao loginDao=new LoginDao();

    /**
     * 验证用户名和密码
     * @param ue 用户提交用户名和密码
     * @return
     */
    public boolean validUserPwd(UserEntity ue){
        //直接调用loginDao完成校验
        return loginDao.validUserPwd(ue.getUsername(),ue.getPassword());
    }
}
