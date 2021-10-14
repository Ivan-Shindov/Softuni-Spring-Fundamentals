package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.entity.views.ModelDetailsView;
import bg.softuni.Mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Controller
public class OffersController {

    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());

        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOfferDetails(@PathVariable long id, Model model) {
        ModelDetailsView modelDetails = offerService.getModelDetails(id);

        model.addAttribute("modelDetails", modelDetails);

        return "details";
    }

    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable long id, Model model) {
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }
}
