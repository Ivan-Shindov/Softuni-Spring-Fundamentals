package com.example.battleshipsexam.service.impl;

import com.example.battleshipsexam.model.binding.LoginUserBindingModel;
import com.example.battleshipsexam.model.binding.RegisterUserBindingModel;
import com.example.battleshipsexam.model.entity.UserEntity;
import com.example.battleshipsexam.model.service.UserServiceModel;
import com.example.battleshipsexam.repository.UserRepository;
import com.example.battleshipsexam.security.CurrentUser;
import com.example.battleshipsexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel findByUsername(String username) {

        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
        if (userEntity == null) {
            return null;
        }

        return modelMapper.map(userEntity, UserServiceModel.class);

    }

    @Override
    public void registerAndLogin(RegisterUserBindingModel registerUserBindingModel) {
        UserServiceModel serviceModel = modelMapper.map(registerUserBindingModel, UserServiceModel.class);

        UserEntity user = modelMapper.map(serviceModel, UserEntity.class);

        currentUser
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setLoggedIn(true);

        userRepository.save(user);
    }

    @Override
    public void login(LoginUserBindingModel loginUserBindingModel) {
        UserServiceModel serviceModel = modelMapper.map(loginUserBindingModel, UserServiceModel.class);

        currentUser
                .setId(serviceModel.getId())
                .setUsername(serviceModel.getUsername())
                .setLoggedIn(true);
    }

    @Override
    public void logout() {
        currentUser.clearFields();
    }

    @Override
    public boolean findByUsernameAndPassword(LoginUserBindingModel loginUserBindingModel) {

        UserServiceModel serviceModel = modelMapper.map(loginUserBindingModel, UserServiceModel.class);

        UserEntity userEntity = userRepository.findByUsernameAndPassword(serviceModel.getUsername(), serviceModel.getPassword()).orElse(null);

        if (userEntity == null) {
            return false;
        }

        return true;

    }

    @Override
    public boolean getCurrentLoggedInUser() {

        return currentUser.isLoggedIn();
    }

}
