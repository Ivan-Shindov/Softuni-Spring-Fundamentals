package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.entity.views.ModelDetailsView;
import bg.softuni.Mobilelele.entity.views.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();

    ModelDetailsView getModelDetails(long id);
    void deleteOffer(long id);
}
