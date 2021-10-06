package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.entity.views.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();
}
