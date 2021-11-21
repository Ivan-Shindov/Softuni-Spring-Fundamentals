package com.example.books.model.dto;

import com.example.books.model.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

public class AuthorDTO {

    private Long id;
    private String firstName;
    private String lastName;

    public AuthorDTO() {

    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public Long getId() {
        return id;
    }

    public AuthorDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
