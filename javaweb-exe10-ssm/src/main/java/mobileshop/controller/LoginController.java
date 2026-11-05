package mobileshop.controller;

import mobileshop.entity.UserEntity;
import mobileshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/signin")
    public String signIn(String username, String password) {
        //请完善代码
        UserEntity ue = new UserEntity();
        ue.setUsername(username);
        ue.setPassword(password);
        if (userService.validUserPwd(ue)) {
            return "index";
        }
        return "error";
    }
}
