package bg.softuni.Mobilelele.init;

import bg.softuni.Mobilelele.service.BrandService;
import bg.softuni.Mobilelele.service.ModelService;
import bg.softuni.Mobilelele.service.OfferService;
import bg.softuni.Mobilelele.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final UserService userService;
    private final OfferService offerService;
    private final BrandService brandService;
    private final ModelService modelService;

    public DBInit(UserService userService, OfferService offerService,
                  BrandService brandService, ModelService modelService) {
        this.userService = userService;
        this.offerService = offerService;
        this.brandService = brandService;
        this.modelService = modelService;
    }


    @Override
    public void run(String... args) throws Exception {

        brandService.initializeBrand();
        modelService.initializeModels();
        userService.initializeUsersAndRoles();
        offerService.initializeOffers();
    }
}
