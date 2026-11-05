public class LoginController {
    private LoginService loginService=new LoginService();
    private LoginView loginView=new LoginView();
    /**
     * 返回页面内容
     * @param username 用户请求用户名
     * @param pwd 用户请求密码
     * @return
     */
    public String login(String username,String pwd){
        //请完善代码,返回页面内容
        UserEntity ue=new UserEntity();
        ue.setUsername(username);
        ue.setPassword(pwd);
        LoginModel model;
        if(loginService.validUserPwd(ue)){
            model=new LoginModel("登录成功");
        }else{
            model=new LoginModel("用户名或密码错误");
        }
        return loginView.render(model);
    }
}
