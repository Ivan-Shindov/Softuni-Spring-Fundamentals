package com.example.cache;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    private String name;
    private Long id;
    private Integer age;

    public Student() {}

    public Student(String name, Long id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }
}
