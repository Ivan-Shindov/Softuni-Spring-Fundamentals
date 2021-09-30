package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.entity.binding.UserLoginBindingModel;
import bg.softuni.Mobilelele.entity.service.UserLoginServiceModel;
import bg.softuni.Mobilelele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {


        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel) {

        UserLoginServiceModel userLogin = new UserLoginServiceModel();

        boolean loginSuccess = userService.login(
                userLogin.setUsername(userLoginBindingModel.getUsername())
                        .setRawPass(userLoginBindingModel.getPassword()));

        LOGGER.info("User tried to login username {} , is successful ? = {}",
                userLoginBindingModel.getUsername(),
                loginSuccess);

        return "redirect:/users/login";
    }

}
