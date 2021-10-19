package com.example.coffeshopapp.web;

import com.example.coffeshopapp.model.view.OrderViewModel;
import com.example.coffeshopapp.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public HomeController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        List<OrderViewModel> orders = orderService.getAllOrderedByPriceDesc();

        model.addAttribute("ordersDesc", orders);
        model.addAttribute("leftTime", orderService.calculateLeftTime(orders));

        return "home";
    }

    @GetMapping("/orders/ready/{id}")
    public String readyOrder(@PathVariable Long id) {

        orderService.readyOrder(id);

        return "redirect:/home";
    }
}

