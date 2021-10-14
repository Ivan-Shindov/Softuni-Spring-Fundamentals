package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.service.OfferAddServiceModel;
import bg.softuni.Mobilelele.model.service.OfferUpdateServiceModel;
import bg.softuni.Mobilelele.model.views.ModelDetailsView;
import bg.softuni.Mobilelele.model.views.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();

    ModelDetailsView getModelDetails(long id);

    void deleteOffer(long id);

    void updateOffer(OfferUpdateServiceModel offerUpdateServiceModel);

    void addOffer(OfferAddServiceModel offerAddServiceModel);
}
