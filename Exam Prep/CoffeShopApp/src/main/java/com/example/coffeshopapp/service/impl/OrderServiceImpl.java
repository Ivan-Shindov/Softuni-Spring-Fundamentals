package com.example.coffeshopapp.service.impl;

import com.example.coffeshopapp.model.entity.CategoryEntity;
import com.example.coffeshopapp.model.entity.OrderEntity;
import com.example.coffeshopapp.model.entity.UserEntity;
import com.example.coffeshopapp.model.service.OrderServiceModel;
import com.example.coffeshopapp.model.service.UserServiceModel;
import com.example.coffeshopapp.repository.OrderRepository;
import com.example.coffeshopapp.security.CurrentUser;
import com.example.coffeshopapp.service.CategoryService;
import com.example.coffeshopapp.service.OrderService;
import com.example.coffeshopapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, CurrentUser currentUser, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel serviceModel) {

        OrderEntity orderEntity = modelMapper.map(serviceModel, OrderEntity.class);
        UserServiceModel userServiceModel =
                userService.findByUsername(currentUser.getUsername());

        CategoryEntity category = categoryService
                .findByCategoryName(serviceModel.getCategory());

        orderEntity.setCategory(category);
        orderEntity.setEmployee(modelMapper.map(userServiceModel, UserEntity.class));

        orderRepository.save(orderEntity);
    }
}
