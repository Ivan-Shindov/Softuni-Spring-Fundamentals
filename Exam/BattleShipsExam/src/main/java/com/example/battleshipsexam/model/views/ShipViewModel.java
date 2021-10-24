package com.example.battleshipsexam.model.views;

import com.example.battleshipsexam.model.entity.enums.CategoryEnum;

import java.time.LocalDate;

public class ShipViewModel {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryEnum category;
    private Long otherUserId;

    public ShipViewModel(){

    }

    public Long getId() {
        return id;
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipViewModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipViewModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipViewModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ShipViewModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public Long getOtherUserId() {
        return otherUserId;
    }

    public ShipViewModel setOtherUserId(Long otherUserId) {
        this.otherUserId = otherUserId;
        return this;
    }
}
