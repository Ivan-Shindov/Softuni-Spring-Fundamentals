package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.entity.binding.UserRegisterBindingModel;
import bg.softuni.Mobilelele.entity.service.UserRegisterServiceModel;
import bg.softuni.Mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegisterController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserRegisterController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register() {


        return "auth-register";
    }

    @PostMapping("/users/register")
    public String registerPost(UserRegisterBindingModel userRegisterBindingModel) {

        UserRegisterServiceModel userServiceModel = modelMapper
                .map(userRegisterBindingModel,UserRegisterServiceModel.class);

        userService.registerAndLogin(userServiceModel);


        return "redirect:/";
    }
}
