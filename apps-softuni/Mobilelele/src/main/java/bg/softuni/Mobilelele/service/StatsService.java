package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.views.StatsView;

public interface StatsService {

    public void onRequest();

    StatsView getStats();
}
