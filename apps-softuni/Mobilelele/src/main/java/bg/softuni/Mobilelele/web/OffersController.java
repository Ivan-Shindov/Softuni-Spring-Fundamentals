package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.model.binding.OfferAddBindingModel;
import bg.softuni.Mobilelele.model.binding.OfferUpdateBindingModel;
import bg.softuni.Mobilelele.model.enums.EngineEnum;
import bg.softuni.Mobilelele.model.enums.TransmissionEnum;
import bg.softuni.Mobilelele.model.service.OfferAddServiceModel;
import bg.softuni.Mobilelele.model.service.OfferUpdateServiceModel;
import bg.softuni.Mobilelele.model.views.ModelDetailsView;
import bg.softuni.Mobilelele.service.BrandService;
import bg.softuni.Mobilelele.service.OfferService;
import bg.softuni.Mobilelele.service.UserService;
import bg.softuni.Mobilelele.service.impl.MobileleUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final BrandService brandService;

    public OffersController(OfferService offerService, ModelMapper modelMapper, UserService userService, BrandService brandService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());

        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOfferDetails(@PathVariable long id, Model model,
                                   @AuthenticationPrincipal MobileleUser mobileleUser) {
        ModelDetailsView modelDetails = offerService.getModelDetails(mobileleUser.getUserIdentifier(), id);

        model.addAttribute("modelDetails", modelDetails);

        return "details";
    }

    @PreAuthorize("@offerServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable long id,
                              Principal principal) {

//        if (!offerService.isOwner(principal.getName(), id)) {
//            throw new Exception();
//        }

        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/offers/{id}/update")
    public String offerUpdate(@PathVariable long id, Model model,
                              @AuthenticationPrincipal MobileleUser mobileleUser) {
        ModelDetailsView modelDetails = offerService.getModelDetails(mobileleUser.getUserIdentifier(), id);

        OfferUpdateBindingModel bindingModel = modelMapper.map(modelDetails,
                OfferUpdateBindingModel.class);

        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        model.addAttribute("offerModel", bindingModel);

        return "update";
    }

    @PatchMapping("/offers/{id}/update")
    public String editOffer(@PathVariable long id,
                            @Valid OfferUpdateBindingModel offerModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("offerModel",offerModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/offers/" + id + "/update/errors";
        }

        OfferUpdateServiceModel serviceModel =
                modelMapper.map(offerModel, OfferUpdateServiceModel.class);
        serviceModel.setId(id);

        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id +"/details";
    }

    @GetMapping("/offers/{id}/update/errors")
    public String offerUpdateErrors(@PathVariable long id, Model model) {

        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());

        return "update";
    }

    @ModelAttribute("offerAddModel")
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model) throws Exception {

        // TODO check for exceptions..

        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }


    @PostMapping("/offers/add")
    public String postOffer(@Valid OfferAddBindingModel offerAddBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            @AuthenticationPrincipal MobileleUser user) {

        if (bindingResult.hasErrors()){

            redirectAttributes
                    .addFlashAttribute("offerAddModel",offerAddBindingModel)
                    .addFlashAttribute(
                    "org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);

            return "redirect:/offers/add";
        }

        OfferAddServiceModel offerAddServiceModel = modelMapper.map(offerAddBindingModel, OfferAddServiceModel.class);

        OfferAddServiceModel addOffer = offerService.addOffer(offerAddServiceModel, user.getUserIdentifier());

        return "redirect:/offers/"+ addOffer.getId() + "/details";
    }
}
