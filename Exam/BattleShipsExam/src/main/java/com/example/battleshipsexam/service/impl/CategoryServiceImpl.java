package com.example.battleshipsexam.service.impl;

import com.example.battleshipsexam.model.entity.CategoryEntity;
import com.example.battleshipsexam.model.entity.enums.CategoryEnum;
import com.example.battleshipsexam.repository.CategoryRepository;
import com.example.battleshipsexam.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialize() {
        if (categoryRepository.count() == 0) {

            for (CategoryEnum value : CategoryEnum.values()) {
                CategoryEntity categoryEntity = new CategoryEntity();
                categoryEntity.setName(value);
                switch (value) {
                    case CARGO: categoryEntity.setDescription("Cargo ship is very good.");
                        break;
                    case BATTLE: categoryEntity.setDescription("Battle ship is for serious battle not for play.");
                        break;
                    case PATROL: categoryEntity.setDescription("Patrol ship keeps the peace in the galaxy.");
                        break;
                }

                categoryRepository.save(categoryEntity);
            }
        }

    }

    @Override
    public CategoryEntity findByCategory(CategoryEnum category) {

       return categoryRepository.findByName(category).orElse(null);

    }
}
