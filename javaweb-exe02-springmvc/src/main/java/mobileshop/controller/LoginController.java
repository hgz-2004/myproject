package mobileshop.controller;

import mobileshop.entity.UserEntity;
import mobileshop.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    private LoginService loginService=new LoginService();

    /**
     * 处理 /login 请求，返回登录页面
     * @return 视图名称 login，由视图解析器拼接为 /WEB-INF/html/login.html
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 处理登录表单提交的 /signin 请求
     * @param username 表单提交的用户名
     * @param password 表单提交的密码
     * @return 校验成功返回 index 视图，失败返回 error 视图
     */
    @RequestMapping("/signin")
    public String signin(String username,String password){
        UserEntity ue=new UserEntity();
        ue.setUsername(username);
        ue.setPassword(password);
        if(loginService.validUserPwd(ue)){
            return "index";
        }
        return "error";
    }
}
