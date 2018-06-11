package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "admin/login";

    }
    @RequestMapping(value = {"/403"}, method = RequestMethod.GET)
    public String error403() {
        return "admin/403";
    }

    @RequestMapping(value = {"/add-user"}, method = RequestMethod.GET)
    public void createUser() {
        User user = new User();
        user.setPassword("user");
        user.setUsername("user");
        userService.saveUser(user);
    }


}
