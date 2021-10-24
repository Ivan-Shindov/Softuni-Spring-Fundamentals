package com.example.battleshipsexam.model.binding;

import com.example.battleshipsexam.model.entity.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddShipBindingModel {

    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryEnum category;

    public AddShipBindingModel() {

    }

    @NotNull
    @Size(min = 2, max = 10)
    public String getName() {
        return name;
    }

    public AddShipBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    @Positive
    public Long getHealth() {
        return health;
    }

    public AddShipBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    @NotNull
    @Positive
    public Long getPower() {
        return power;
    }

    public AddShipBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    @PastOrPresent
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public AddShipBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @NotNull
    public CategoryEnum getCategory() {
        return category;
    }

    public AddShipBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
