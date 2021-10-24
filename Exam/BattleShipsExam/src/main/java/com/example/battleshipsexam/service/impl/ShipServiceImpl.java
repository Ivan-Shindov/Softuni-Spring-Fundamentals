package com.example.battleshipsexam.service.impl;

import com.example.battleshipsexam.model.binding.AddShipBindingModel;
import com.example.battleshipsexam.model.entity.CategoryEntity;
import com.example.battleshipsexam.model.entity.ShipEntity;
import com.example.battleshipsexam.model.entity.UserEntity;
import com.example.battleshipsexam.model.service.ShipServiceModel;
import com.example.battleshipsexam.model.service.UserServiceModel;
import com.example.battleshipsexam.model.views.ShipViewModel;
import com.example.battleshipsexam.repository.ShipRepository;
import com.example.battleshipsexam.security.CurrentUser;
import com.example.battleshipsexam.service.CategoryService;
import com.example.battleshipsexam.service.ShipService;
import com.example.battleshipsexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper,
                           CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addShip(AddShipBindingModel addShipBindingModel) {
        ShipServiceModel serviceModel = modelMapper.map(addShipBindingModel, ShipServiceModel.class);

        UserServiceModel userModel = userService.findByUsername(currentUser.getUsername());
        UserEntity user = modelMapper.map(userModel, UserEntity.class);

        CategoryEntity category = categoryService.findByCategory(serviceModel.getCategory());

        ShipEntity ship = modelMapper.map(serviceModel, ShipEntity.class);
        ship.setUser(user);
        ship.setCategory(category);


        shipRepository.save(ship);
    }

    @Override
    public Set<ShipViewModel> getShipsForCurrentUser() {

        Set<ShipEntity> allForCurrentUser = shipRepository.findAllForCurrentUser(currentUser.getUsername());

        return allForCurrentUser
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity,ShipViewModel.class))
                .collect(Collectors.toSet());

    }

    @Override
    public Set<ShipViewModel> getAllFromAnotherUser() {
        Set<ShipEntity> allForCurrentUser = shipRepository.findAllForOtherUser(currentUser.getUsername());

        return allForCurrentUser
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity,ShipViewModel.class))
                .collect(Collectors.toSet());
    }

    @Override
    public List<ShipViewModel> findAllOrderedByHealth() {

        return shipRepository.findAllOrderedByHealth().stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void fire(String attacker, String defender) {

        ShipEntity shipAttacker = shipRepository.findByName(attacker);
        ShipEntity shipDefender = shipRepository.findByName(defender);

        shipDefender.setHealth(shipDefender.getHealth() - shipAttacker.getPower());

        if (shipDefender.getHealth() <= 0) {
            shipRepository.delete(shipDefender);

        } else {
            shipRepository.save(shipDefender);
        }
    }

    @Override
    public boolean isLoggedInUser() {
        return currentUser.isLoggedIn();
    }
}
