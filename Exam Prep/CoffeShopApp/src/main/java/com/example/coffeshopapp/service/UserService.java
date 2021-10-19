package com.example.coffeshopapp.service;

import com.example.coffeshopapp.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerAndLogin(UserServiceModel map);

    void login(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

    void logout();
}
