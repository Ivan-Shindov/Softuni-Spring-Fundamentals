package com.example.battleshipsexam.web;

import com.example.battleshipsexam.model.binding.LoginUserBindingModel;
import com.example.battleshipsexam.model.binding.RegisterUserBindingModel;
import com.example.battleshipsexam.model.service.UserServiceModel;
import com.example.battleshipsexam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(Model model) {
        if (!model.containsAttribute("loginUserBindingModel")) {
            model.addAttribute("loginUserBindingModel", new LoginUserBindingModel());
        }

        if (!model.containsAttribute("noSuchUser")) {
            model.addAttribute("noSuchUser", false);
        }

        return "login";
    }

    @PostMapping("/users/login")
    public String postLogin(@Valid LoginUserBindingModel loginUserBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("loginUserBindingModel", loginUserBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginUserBindingModel",
                            bindingResult);

            return "redirect:/users/login";
        }

        UserServiceModel serviceModel = userService
                .findByUsername(loginUserBindingModel.getUsername());

        if (serviceModel == null) {
            redirectAttributes
                    .addFlashAttribute("noSuchUser", true)
                    .addFlashAttribute("loginUserBindingModel", loginUserBindingModel);

            return "redirect:login";
        }

        if (!userService.findByUsernameAndPassword(loginUserBindingModel)) {
            redirectAttributes
                    .addFlashAttribute("noSuchUser", true)
                    .addFlashAttribute("loginUserBindingModel", loginUserBindingModel);

            return "redirect:login";
        }


        userService.login(loginUserBindingModel);

        return "redirect:/home";
    }

    @GetMapping("/users/register")
    public String register(Model model) {

        if (!model.containsAttribute("registerUserBindingModel")) {
            model.addAttribute("registerUserBindingModel", new RegisterUserBindingModel());
        }

        return "register";
    }

    @PostMapping("/users/register")
    public String postRegister(@Valid RegisterUserBindingModel registerUserBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !registerUserBindingModel.getPassword()
                .equals(registerUserBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("registerUserBindingModel", registerUserBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerUserBindingModel", bindingResult);

            return "redirect:/users/register";
        }

        UserServiceModel serviceModel = userService.findByUsername(registerUserBindingModel.getUsername());

        if (serviceModel != null) {
            redirectAttributes
                    .addFlashAttribute("registerUserBindingModel", registerUserBindingModel);

            return "redirect:/users/register";
        }

        userService.registerAndLogin(registerUserBindingModel);


        return "home";
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logout();
        return "index";
    }

}
