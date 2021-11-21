package com.example.books.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class AuthorEntity extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private Set<BookEntity> books;

    public AuthorEntity() {
        this.books = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
//
    public Set<BookEntity> getBooks() {
        return books;
    }

    public AuthorEntity setBooks(Set<BookEntity> books) {
        this.books = books;
        return this;
    }
}
