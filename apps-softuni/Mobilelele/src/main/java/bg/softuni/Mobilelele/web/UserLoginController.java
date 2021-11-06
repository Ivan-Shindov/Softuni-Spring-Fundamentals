package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserLoginController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(Model model) {

        if (!model.containsAttribute("validation")) {
            model.addAttribute("validation",false);
        }

        return "auth-login";
    }

//    @ModelAttribute
//    public String username() {
//        return UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;
//    }

    @PostMapping("/users/login-error")
    public String failLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                    String username,
            RedirectAttributes redirectAttributes) {

        redirectAttributes
                .addFlashAttribute("validation",true)
                .addFlashAttribute("username", username);


        return "redirect:/users/login";
    }

}
