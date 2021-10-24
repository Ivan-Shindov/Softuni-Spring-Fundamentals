package com.example.battleshipsexam.web;

import com.example.battleshipsexam.model.views.ShipViewModel;
import com.example.battleshipsexam.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class HomeController {
    private final ShipService shipService;

    public HomeController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }


    @GetMapping("/home")
    public String home(Model model) {

        Set<ShipViewModel> shipsForCurrentUser = shipService.getShipsForCurrentUser();
        Set<ShipViewModel> shipsFromAnotherUser = shipService.getAllFromAnotherUser();

        model.addAttribute("shipsForCurrentUser",shipsForCurrentUser)
                .addAttribute("shipsFromAnotherUser",shipsFromAnotherUser)
                .addAttribute("allShips", shipService.findAllOrderedByHealth());

        return "home";
    }

    @PostMapping("/home")
    public String postHome(@RequestParam("attacker") String attacker,
                           @RequestParam("defender") String defender) {

        if (shipService.isLoggedInUser() == false) {

            return "redirect:/users/login";
        }

        shipService.fire(attacker,defender);

        return "redirect:/home";
    }
}
