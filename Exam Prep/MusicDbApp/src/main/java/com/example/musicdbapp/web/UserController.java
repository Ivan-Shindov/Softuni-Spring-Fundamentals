package com.example.musicdbapp.web;

import com.example.musicdbapp.model.binding.UserLoginBindingModel;
import com.example.musicdbapp.model.binding.UserRegisterBindingModel;
import com.example.musicdbapp.model.service.UserLoginServiceModel;
import com.example.musicdbapp.model.service.UserRegisterServiceModel;
import com.example.musicdbapp.service.UserService;
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
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel",new UserRegisterBindingModel());
        }

        return "register";
    }


    @PostMapping("/users/register")
    public String postRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        UserRegisterServiceModel serviceModel = modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class);

        if (userService.isThereSameUser(serviceModel.getUsername())) {
            return "redirect:register";
        }

        userService.registerAndLogin(serviceModel);


        return "home";
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logout();

        return "redirect:/";
    }

    @ModelAttribute(name = "noSuchUser")
    private boolean noSuchUser() {
        return false;
    }


    @GetMapping("/users/login")
    public String login(Model model) {

        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel",new UserLoginBindingModel());
        }

        return "login";
    }

    @PostMapping("/users/login")
    public String postLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel",userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",bindingResult);

            return "redirect:login";
        }

       if(!userService.isThereSameUser(userLoginBindingModel.getUsername())){
           redirectAttributes
                   .addFlashAttribute("noSuchUser",true);

           return "redirect:login";
       }



        userService.login(modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class));

        return "redirect:/home";
    }

}
