package com.example.battleshipsexam.service;

import com.example.battleshipsexam.model.binding.LoginUserBindingModel;
import com.example.battleshipsexam.model.binding.RegisterUserBindingModel;
import com.example.battleshipsexam.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel findByUsername(String username);

    void registerAndLogin(RegisterUserBindingModel registerUserBindingModel);

    void login(LoginUserBindingModel loginUserBindingModel);

    void logout();

    boolean findByUsernameAndPassword(LoginUserBindingModel loginUserBindingModel);
}
