package com.example.battleshipsexam.service;

import com.example.battleshipsexam.model.entity.CategoryEntity;
import com.example.battleshipsexam.model.entity.enums.CategoryEnum;

public interface CategoryService {

    void initialize();

    CategoryEntity findByCategory(CategoryEnum category);
}
