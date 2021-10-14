package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.entity.Offer;
import bg.softuni.Mobilelele.entity.enums.EngineEnum;
import bg.softuni.Mobilelele.entity.enums.TransmissionEnum;
import bg.softuni.Mobilelele.entity.views.ModelDetailsView;
import bg.softuni.Mobilelele.entity.views.OfferSummaryView;
import bg.softuni.Mobilelele.repository.ModelRepository;
import bg.softuni.Mobilelele.repository.OfferRepository;
import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper,
                            ModelRepository modelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
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
                    .setSeller(userRepository.findByUsername("pesho").orElse(null))
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
                    .setSeller(userRepository.findByUsername("pesho").orElse(null))
                    .setTransmission(TransmissionEnum.AUTOMATIC);

            Offer offer3 = new Offer();

            offer3
                    .setModel(modelRepository.findById(3L).orElse(null))
                    .setImageUrl("https://media.autoexpress.co.uk/image/private/s--VfWlNFGx--/v1609948123/autoexpress/2021/01/New%20BMW%20X5%20M%20Competition%202021%20UK-16.jpg")
                    .setEngine(EngineEnum.GASOLINE)
                    .setMileage(126000)
                    .setYear(2020)
                    .setPrice(BigDecimal.valueOf(108_555))
                    .setSeller(userRepository.findByUsername("admin").orElse(null))
                    .setTransmission(TransmissionEnum.AUTOMATIC);

            offerRepository.save(offer2);
            offerRepository.saveAll(List.of(offer,offer3));
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
        view.setImage(offer.getModel().getImageUrl());
        return view;
    }

    @Override
    public void deleteOffer(long id) {
        offerRepository.deleteById(id);
    }

    private OfferSummaryView mapper(Offer offer) {

        OfferSummaryView mapped = modelMapper.map(offer, OfferSummaryView.class);
        mapped.setModel(offer.getModel().getName());
        return mapped;
    }
}
