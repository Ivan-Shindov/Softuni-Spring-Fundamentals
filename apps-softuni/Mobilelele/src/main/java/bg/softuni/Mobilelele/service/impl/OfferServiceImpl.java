package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.entity.Offer;
import bg.softuni.Mobilelele.entity.views.OfferSummaryView;
import bg.softuni.Mobilelele.repository.OfferRepository;
import bg.softuni.Mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void initializeOffers() {

    }

    @Override
    public List<OfferSummaryView> getAllOffers() {


        return offerRepository.findAll()
                .stream()
                .map(this::mapper)
                .collect(Collectors.toList());
    }

    private OfferSummaryView mapper(Offer offer) {

        return new OfferSummaryView();
    }
}
