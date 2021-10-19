package com.example.coffeshopapp.service.impl;

import com.example.coffeshopapp.model.entity.UserEntity;
import com.example.coffeshopapp.model.service.UserServiceModel;
import com.example.coffeshopapp.model.view.EmployeeViewModel;
import com.example.coffeshopapp.repository.UserRepository;
import com.example.coffeshopapp.security.CurrentUser;
import com.example.coffeshopapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public UserServiceModel registerAndLogin(UserServiceModel model) {
        UserEntity user = modelMapper.map(model, UserEntity.class);

        userRepository.save(user);

        login(model);

        return modelMapper.map(user,UserServiceModel.class);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser
                .setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername())
                .setLoggedIn(true);
    }

    @Override
    public UserServiceModel findByUsername(String username) {

        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);

        if (userEntity == null) {
            return null;
        }

        return modelMapper.map(userEntity,UserServiceModel.class);
    }

    @Override
    public void logout() {
        currentUser.clearFields();
    }

    @Override
    public List<EmployeeViewModel> getAllByCountOrdersDesc() {

       return userRepository.findAllOrderByCountInDesc()
               .stream()
               .map(userEntity -> {
                   EmployeeViewModel model = modelMapper.map(userEntity, EmployeeViewModel.class);
                    model.setCountOfOrders(userEntity.getOrders().size());
                    return model;
               })
               .collect(Collectors.toList());
    }

}
