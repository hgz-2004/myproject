package mobileshop.controller;

import mobileshop.entity.UserEntity;
import mobileshop.entity.RegisterVo;
import mobileshop.service.UserService;
import mobileshop.vo.ResMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register2", method = RequestMethod.GET)
    public String register2() {
        return "register2";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String username, String password, String email, Model model) {
        ModelMap map = new ModelMap();
        String view = signUp(map, username, password, email);
        model.addAllAttributes(map);
        return view;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(ModelMap map, String username, String password, String email) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)
                || StringUtils.isBlank(email)) {
            map.addAttribute("msg", "用户名，密码，邮箱均不能为空");
            return "msg";
        }
        if (userService.existUserNameOrEmail(username, email)) {
            map.addAttribute("msg", "用户名或Email已存在");
            return "msg";
        }
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        if (userService.save(user)) {
            map.addAttribute("msg", "注册成功");
        } else {
            map.addAttribute("msg", "注册失败");
        }
        return "msg";
    }

    @RequestMapping(value = "/signup2", method = RequestMethod.POST)
    @ResponseBody
    public ResMsg signup2(@RequestBody RegisterVo vo) {
        ResMsg response = new ResMsg();
        if (vo == null || StringUtils.isBlank(vo.getUsername())
                || StringUtils.isBlank(vo.getPassword())
                || StringUtils.isBlank(vo.getEmail())) {
            response.setErrcode("400");
            response.setErrmsg("用户名，密码，邮箱均不能为空");
            return response;
        }
        if (userService.existUserNameOrEmail(vo.getUsername(), vo.getEmail())) {
            response.setErrcode("409");
            response.setErrmsg("用户名或Email已存在");
            return response;
        }
        UserEntity user = new UserEntity();
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword());
        user.setEmail(vo.getEmail());
        if (userService.save(user)) {
            response.setErrcode("0");
            response.setErrmsg("注册成功");
        } else {
            response.setErrcode("500");
            response.setErrmsg("注册失败");
        }
        return response;
    }
}
