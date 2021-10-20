package com.example.coffeshopapp.service;

import com.example.coffeshopapp.model.service.OrderServiceModel;
import com.example.coffeshopapp.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    void addOrder(OrderServiceModel serviceModel);

    List<OrderViewModel> getAllOrderedByPriceDesc();

    boolean readyOrder(Long id);

    Integer calculateLeftTime(List<OrderViewModel> orders);
}
