package com.example.coffeshopapp.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDateTime orderTime;

    @ManyToOne
    private CategoryEntity category;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String description;

    @ManyToOne
    private UserEntity employee;

    public OrderEntity() {

    }

    public String getName() {
        return name;
    }

    public OrderEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public OrderEntity setPrice(Double price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderEntity setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public OrderEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getEmployee() {
        return employee;
    }

    public OrderEntity setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }
}
