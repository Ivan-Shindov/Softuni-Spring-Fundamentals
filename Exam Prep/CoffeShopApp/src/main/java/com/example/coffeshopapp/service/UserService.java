package com.example.coffeshopapp.service;

import com.example.coffeshopapp.model.service.UserServiceModel;
import com.example.coffeshopapp.model.view.EmployeeViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerAndLogin(UserServiceModel map);

    void login(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

    void logout();

    List<EmployeeViewModel> getAllByCountOrdersDesc();
}
