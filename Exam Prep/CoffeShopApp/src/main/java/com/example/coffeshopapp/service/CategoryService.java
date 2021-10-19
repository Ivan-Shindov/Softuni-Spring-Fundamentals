package com.example.coffeshopapp.service;

import com.example.coffeshopapp.model.entity.CategoryEntity;
import com.example.coffeshopapp.model.entity.enums.CategoryEnum;

public interface CategoryService {

    void initializeCategories();

    CategoryEntity findByCategoryName(CategoryEnum name);
}
