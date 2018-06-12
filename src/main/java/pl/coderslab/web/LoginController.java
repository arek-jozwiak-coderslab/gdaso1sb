package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

@Controller
public class LoginController {

    private final UserService userService;
    private final UserRepository userRepository;

    public LoginController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
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
    @RequestMapping(value = "/remove-user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String createUser(@PathVariable long id) {
       User user = userRepository.findOne(id);
//       user.getRoles().clear();
       userRepository.delete(user);
       return "deleted";
    }


}
