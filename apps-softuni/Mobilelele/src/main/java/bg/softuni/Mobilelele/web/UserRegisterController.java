package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.Mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.Mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
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

            if (!userRegModel.getPassword().equals(userRegModel.getConfirmPassword())) {

                redirectAttributes.addFlashAttribute("userRegModel", userRegModel);
                redirectAttributes.addFlashAttribute("mismatch", true);

                return "redirect:/users/register";
            }

            redirectAttributes.addFlashAttribute("userRegModel", userRegModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegModel", bindingResult);

            return "redirect:/users/register";

        }


        UserRegisterServiceModel userServiceModel = modelMapper
                .map(userRegModel, UserRegisterServiceModel.class);

        userService.registerAndLogin(userServiceModel);

        return "redirect:/";
    }
}
