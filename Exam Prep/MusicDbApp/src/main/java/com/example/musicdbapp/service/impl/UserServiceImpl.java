package com.example.musicdbapp.service.impl;

import com.example.musicdbapp.model.entity.UserEntity;
import com.example.musicdbapp.model.service.UserLoginServiceModel;
import com.example.musicdbapp.model.service.UserRegisterServiceModel;
import com.example.musicdbapp.repository.UserRepository;
import com.example.musicdbapp.security.CurrentUser;
import com.example.musicdbapp.service.UserService;
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
    public void registerAndLogin(UserRegisterServiceModel serviceModel) {

        UserEntity userEntity = modelMapper.map(serviceModel,UserEntity.class);

        userRepository.save(userEntity);

        currentUser
                .setId(userEntity.getId())
                .setUsername(userEntity.getUsername())
                .setLoggedIn(true);

    }

    @Override
    public boolean isThereSameUser(String username) {

        UserEntity userEntity = userRepository.findByUsername(username)
                .orElse(null);

        return userEntity != null;
    }

    @Override
    public void logout() {
        currentUser.setLoggedIn(false)
                .setUsername(null)
                .setId(null);
    }

    @Override
    public void login(UserLoginServiceModel serviceModel) {
        UserEntity userEntity = userRepository.findByUsername(serviceModel.getUsername())
                .orElse(null);

        if (userEntity != null) {
            UserLoginServiceModel mappedModel = modelMapper.map(userEntity, UserLoginServiceModel.class);

            currentUser.setId(mappedModel.getId())
                    .setUsername(mappedModel.getUsername())
                    .setLoggedIn(true);
        }
    }

    @Override
    public UserEntity findByUsername(String username) {

        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);

        if (userEntity == null) {
            return null;
        }

        return userEntity;
    }
}
