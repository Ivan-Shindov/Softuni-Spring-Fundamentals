package com.example.coffeshopapp.web;

import com.example.coffeshopapp.model.binding.AddOrderBindingModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final ModelMapper modelMapper;

    public OrderController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/orders/add")
    public String orders() {


        return "order-add";
    }

    @ModelAttribute
    public AddOrderBindingModel orderBindingModel() {
        return new AddOrderBindingModel();
    }

    @PostMapping("/orders/add")
    public String postOrder(@Valid AddOrderBindingModel addOrderBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addOrderBindingModel", addOrderBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOrderBindingModel", bindingResult);

            return "redirect:orders";
        }



        return "redirect:/home";
    }

}
