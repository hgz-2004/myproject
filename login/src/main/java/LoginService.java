public class LoginService {
    private LoginDao loginDao=new LoginDao();

    /**
     * 验证用户名和密码
     * @param ue 用户提交用户名和密码
     * @return
     */
    public boolean validUserPwd(UserEntity ue){
        //请完善代码，考虑直接调用loginDao
        return loginDao.validUserPwd(ue.getUsername(),ue.getPassword());
    }
}
