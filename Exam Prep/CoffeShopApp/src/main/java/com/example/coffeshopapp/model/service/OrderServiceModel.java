package com.example.coffeshopapp.model.service;

import com.example.coffeshopapp.model.entity.CategoryEntity;
import com.example.coffeshopapp.model.entity.UserEntity;
import com.example.coffeshopapp.model.entity.enums.CategoryEnum;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class OrderServiceModel {

    private Long id;
    private String name;
    private BigInteger price;
    private LocalDateTime orderTime;
    private CategoryEnum category;
    private String description;
    private UserEntity employee;

    public OrderServiceModel() {

    }

    public Long getId() {
        return id;
    }

    public OrderServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigInteger getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigInteger price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderServiceModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public OrderServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public UserEntity getEmployee() {
        return employee;
    }

    public OrderServiceModel setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }
}