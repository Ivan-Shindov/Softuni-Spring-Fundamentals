package com.example.coffeshopapp.service.impl;

import com.example.coffeshopapp.model.entity.CategoryEntity;
import com.example.coffeshopapp.model.entity.enums.CategoryEnum;
import com.example.coffeshopapp.repository.CategoryRepository;
import com.example.coffeshopapp.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initializeCategories() {
        if (categoryRepository.count() == 0) {

            for (CategoryEnum name : CategoryEnum.values()) {
                CategoryEntity category = new CategoryEntity();
                category.setName(name);
                switch (name) {
                    case CAKE -> category.setNeededTime(10);
                    case COFFEE -> category.setNeededTime(2);
                    case DRINK -> category.setNeededTime(1);
                    case OTHER -> category.setNeededTime(5);
                }

                categoryRepository.save(category);
            }
        }
    }
}
