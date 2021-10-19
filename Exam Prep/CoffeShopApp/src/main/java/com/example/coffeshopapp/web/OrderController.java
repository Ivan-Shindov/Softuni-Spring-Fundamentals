package com.example.coffeshopapp.web;

import com.example.coffeshopapp.model.binding.AddOrderBindingModel;
import com.example.coffeshopapp.model.service.OrderServiceModel;
import com.example.coffeshopapp.service.OrderService;
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
    private final OrderService orderService;

    public OrderController(ModelMapper modelMapper, OrderService orderService) {
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @GetMapping("/orders/add")
    public String getOrdersAdd() {


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

            return "redirect:/orders/add";
        }

        orderService.addOrder(modelMapper.map(addOrderBindingModel, OrderServiceModel.class));



        return "redirect:/home";
    }

}
