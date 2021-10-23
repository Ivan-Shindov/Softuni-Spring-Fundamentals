package com.example.musicdbapp.service;

import com.example.musicdbapp.model.entity.UserEntity;
import com.example.musicdbapp.model.service.UserLoginServiceModel;
import com.example.musicdbapp.model.service.UserRegisterServiceModel;

public interface UserService {

    void registerAndLogin(UserRegisterServiceModel serviceModel);

    boolean isThereSameUser(String username);

    void logout();

    void login(UserLoginServiceModel serviceModel);

    UserEntity findByUsername(String username);
}
