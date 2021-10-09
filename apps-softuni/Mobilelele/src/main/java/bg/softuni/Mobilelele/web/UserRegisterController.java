package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.entity.binding.UserRegisterBindingModel;
import bg.softuni.Mobilelele.entity.service.UserRegisterServiceModel;
import bg.softuni.Mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserRegisterController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserRegisterController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("userRegModel")
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }


    @GetMapping("/users/register")
    public String register() {


        return "auth-register";
    }

    @PostMapping("/users/register")
    public String registerPost(@Valid UserRegisterBindingModel userRegModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegModel",userRegModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegModel",bindingResult);

            return "redirect:/users/register";
        }

        UserRegisterServiceModel userServiceModel = modelMapper
                .map(userRegModel, UserRegisterServiceModel.class);

        if (!userService.isUserNameFree(userServiceModel.getUsername())) {
            redirectAttributes.addFlashAttribute("userRegModel",userRegModel);
            redirectAttributes.addFlashAttribute("usernameOccupied", true);

            return "redirect:/users/register";
        } else {
            userService.registerAndLogin(userServiceModel);
        }

        return "redirect:/";
    }
}
