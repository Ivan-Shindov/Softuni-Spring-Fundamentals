package com.example.coffeshopapp.model.binding;

import com.example.coffeshopapp.model.entity.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddOrderBindingModel {

    @Size(min = 3,max = 20)
    @NotNull
    private String name;

    @Positive
    @NotNull
    private BigDecimal price;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
    private LocalDateTime orderedTime;

    @NotNull
    private CategoryEnum category;

    @Size(min = 5)
    @NotNull
    private String description;

    public AddOrderBindingModel(){}

    public String getName() {
        return name;
    }

    public AddOrderBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOrderBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public AddOrderBindingModel setOrderedTime(LocalDateTime orderedTime) {
        this.orderedTime = orderedTime;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public AddOrderBindingModel setCategory (CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOrderBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
