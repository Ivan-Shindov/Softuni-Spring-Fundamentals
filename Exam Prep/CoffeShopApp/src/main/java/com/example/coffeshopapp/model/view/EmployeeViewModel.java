package com.example.coffeshopapp.model.view;

public class EmployeeViewModel {

    private Long id;
    private String username;
    private Integer countOfOrders;

    public EmployeeViewModel() {

    }

    public Long getId() {
        return id;
    }

    public EmployeeViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public EmployeeViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getCountOfOrders() {
        return countOfOrders;
    }

    public EmployeeViewModel setCountOfOrders(Integer countOfOrders) {
        this.countOfOrders = countOfOrders;
        return this;
    }
}
