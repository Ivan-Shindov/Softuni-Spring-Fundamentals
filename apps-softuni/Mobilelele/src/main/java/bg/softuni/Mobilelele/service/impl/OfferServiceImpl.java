package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.model.entity.*;
import bg.softuni.Mobilelele.model.enums.CategoryEnum;
import bg.softuni.Mobilelele.model.enums.EngineEnum;
import bg.softuni.Mobilelele.model.enums.RoleEnum;
import bg.softuni.Mobilelele.model.enums.TransmissionEnum;
import bg.softuni.Mobilelele.model.service.OfferAddServiceModel;
import bg.softuni.Mobilelele.model.service.OfferUpdateServiceModel;
import bg.softuni.Mobilelele.model.views.ModelDetailsView;
import bg.softuni.Mobilelele.model.views.OfferSummaryView;
import bg.softuni.Mobilelele.repository.ModelRepository;
import bg.softuni.Mobilelele.repository.OfferRepository;
import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.service.BrandService;
import bg.softuni.Mobilelele.service.OfferService;
import bg.softuni.Mobilelele.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository, ModelMapper modelMapper,
                            ModelRepository modelRepository, BrandService brandService) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    @Override
    public void initializeOffers() {

        if (offerRepository.count() == 0) {
            Offer offer = new Offer();
            offer
                    .setDescription("Качваш се и караш")
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setImageUrl("https://cdn.motor1.com/images/mgl/z2mo6/s1/mercedes-amg-gle-63-s-coupe.jpg")
                    .setEngine(EngineEnum.DIESEL)
                    .setMileage(20000)
                    .setYear(2019)
                    .setPrice(BigDecimal.valueOf(200000))
                    .setSeller(userRepository.findByUsername("pesho").get())
                    .setTransmission(TransmissionEnum.AUTOMATIC);

            Offer offer2 = new Offer();

            offer2
                    .setDescription("Качваш се и караш,кефиш се на макс")
                    .setImageUrl("https://autodius.com/wp-content/uploads/2018/07/2018-mercedes-benz-s63-amg.jpg")
                    .setModel(modelRepository.findById(2L).orElse(null))
                    .setEngine(EngineEnum.GASOLINE)
                    .setMileage(10000)
                    .setYear(2018)
                    .setPrice(BigDecimal.valueOf(204200))
                    .setSeller(userRepository.findByUsername("pesho").get())
                    .setTransmission(TransmissionEnum.AUTOMATIC);

            Offer offer3 = new Offer();

            offer3
                    .setModel(modelRepository.findById(3L).orElse(null))
                    .setImageUrl("https://kolalok.com/newimage/small/2018-x5-g05-bmw.jpg")
                    .setEngine(EngineEnum.GASOLINE)
                    .setMileage(126000)
                    .setYear(2020)
                    .setPrice(BigDecimal.valueOf(108_555))
                    .setSeller(userRepository.findByUsername("admin").get())
                    .setTransmission(TransmissionEnum.AUTOMATIC);

            offerRepository.save(offer2);
            offerRepository.saveAll(List.of(offer, offer3));
        }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {


        return offerRepository
                .findAll()
                .stream()
                .map(this::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public ModelDetailsView getModelDetails(long inputId) {
        Offer offer = offerRepository.findById(inputId).orElse(null);

        ModelDetailsView view = modelMapper.map(offer, ModelDetailsView.class);

        String brand = offer.getModel().getBrand().getName();
        view.setBrandName(brand);

        view.setSeller(offer.getSeller().getFirstName() +
                " " + offer.getSeller().getLastName());
        view.setImage(offer.getImageUrl());
        return view;
    }

    @Override
    public void deleteOffer(long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public boolean isOwner(String username, Long offerId) {
        Optional<Offer> offerOptional = this.offerRepository.findById(offerId);

        Optional<User> caller = this.userRepository.findByUsername(username);

        if (offerOptional.isEmpty() || caller.isEmpty()) {
            return false;
        } else {
            Offer offer = offerOptional.get();

            return isAdmin(caller.get()) ||
                       offer.getSeller().getUsername().equalsIgnoreCase(username);
        }
    }

    private boolean isAdmin(User user) {
        return user.getRoles().stream()
                .map(Role::getRole)
                .anyMatch(r -> r == RoleEnum.ADMIN);
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel offerModel) {
        Offer offer = offerRepository.findById(offerModel.getId())
                .orElseThrow(() -> new ObjectNotFoundException("offer with " + offerModel.getId() + " not found."));

        offer
                .setPrice(offerModel.getPrice())
                .setTransmission(offerModel.getTransmission())
                .setYear(offerModel.getYear())
                .setImageUrl(offerModel.getImage())
                .setMileage(offerModel.getMileage())
                .setEngine(offerModel.getEngine())
                .setDescription(offerModel.getDescription());

        offerRepository.save(offer);
    }

    @Override
    public OfferAddServiceModel addOffer(OfferAddServiceModel offerAddServiceModel, String owner) {
        String brandName = offerAddServiceModel.getBrand();
        Brand brand = brandService.findByBrandOrCreate(brandName);

        Model model = new Model();
        model.setBrand(brand)
                .setCategory(CategoryEnum.CAR)
                .setName(offerAddServiceModel.getModel())
                .setEndYear(2018)
                .setStartYear(2010)
                .setMileage(offerAddServiceModel.getMileage())
                .setImageUrl(offerAddServiceModel.getImageUrl());

        brandService.addModel(model,brand);

        modelRepository.save(model);

        Offer offer = modelMapper.map(offerAddServiceModel, Offer.class);

        offer
                .setModel(model)
                .setSeller(userRepository.findByUsername(owner).orElseThrow());

        offerRepository.save(offer);

        return modelMapper.map(offer,OfferAddServiceModel.class);
    }

    private OfferSummaryView mapper(Offer offer) {

        OfferSummaryView mapped = modelMapper.map(offer, OfferSummaryView.class);
        mapped.setModel(offer.getModel().getName());
        mapped.setBrand(offer.getModel().getBrand().getName());

        return mapped;
    }
}
