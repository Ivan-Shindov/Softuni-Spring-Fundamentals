package com.example.battleshipsexam.service;

import com.example.battleshipsexam.model.binding.AddShipBindingModel;
import com.example.battleshipsexam.model.views.ShipViewModel;

import java.util.List;
import java.util.Set;

public interface ShipService {

    void addShip(AddShipBindingModel addShipBindingModel);

    Set<ShipViewModel> getShipsForCurrentUser();

    Set<ShipViewModel> getAllFromAnotherUser();

    List<ShipViewModel> findAllOrderedByHealth();

    void fire(String attacker, String defender);

    boolean isLoggedInUser();
}
