package com.example.coffeshopapp.web;

import com.example.coffeshopapp.model.view.EmployeeViewModel;
import com.example.coffeshopapp.model.view.OrderViewModel;
import com.example.coffeshopapp.service.OrderService;
import com.example.coffeshopapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public HomeController(OrderService orderService, ModelMapper modelMapper, UserService userService) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        List<OrderViewModel> orders = orderService.getAllOrderedByPriceDesc();
        List<EmployeeViewModel> employees = userService.getAllByCountOrdersDesc();

        model.addAttribute("ordersDesc", orders);
        model.addAttribute("leftTime", orderService.calculateLeftTime(orders));
        model.addAttribute("employees", employees);

        return "home";
    }

    @ModelAttribute(name = "notCorrectUser")
    public boolean notCorrectUser() {
        return false;
    }

    @GetMapping("/orders/ready/{id}")
    public String readyOrder(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        boolean orderBool = orderService.readyOrder(id);

        if (!orderBool) {
            redirectAttributes.addFlashAttribute("notCorrectUser", true);
        }


        return "redirect:/home";
    }
}

