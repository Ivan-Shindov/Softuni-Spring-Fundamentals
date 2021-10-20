package com.example.coffeshopapp.model.view;

import com.example.coffeshopapp.model.entity.CategoryEntity;
import com.example.coffeshopapp.model.entity.enums.CategoryEnum;

import java.math.BigInteger;

public class OrderViewModel {

    private Long id;
    private String name;
    private Double price;
    private CategoryEntity category;
    private String description;


    public OrderViewModel() {

    }

    public String getName() {
        return name;
    }

    public OrderViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public OrderViewModel setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public OrderViewModel setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }
}
