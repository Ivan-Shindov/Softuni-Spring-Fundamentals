package com.example.battleshipsexam.web;

import com.example.battleshipsexam.model.binding.AddShipBindingModel;
import com.example.battleshipsexam.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {
    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/ships/add-ship")
    public String getAddShip(Model model) {
        if (!model.containsAttribute("addShipBindingModel")) {
            model.addAttribute("addShipBindingModel", new AddShipBindingModel());
        }

        return "ship-add";
    }


    @PostMapping("/ships/add-ship")
    public String addShip(@Valid AddShipBindingModel addShipBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addShipBindingModel", addShipBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addShipBindingModel",
                            bindingResult);

            return "redirect:/ships/add-ship";
        }

        shipService.addShip(addShipBindingModel);


        return "redirect:/home";
    }
}
