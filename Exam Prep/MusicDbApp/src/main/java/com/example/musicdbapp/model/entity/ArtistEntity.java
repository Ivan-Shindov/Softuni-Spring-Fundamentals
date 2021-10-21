package com.example.musicdbapp.model.entity;

import com.example.musicdbapp.model.entity.enums.ArtistEnum;

import javax.persistence.*;

@Table(name = "artists")
@Entity
public class ArtistEntity extends BaseEntity {

    private ArtistEnum name;
    private String careerInformation;

    public ArtistEntity(){

    }

    @Column(columnDefinition = "LONGTEXT",name = "career_information")
    public String getCareerInformation() {
        return careerInformation;
    }

    public ArtistEntity setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public ArtistEnum getName() {
        return name;
    }

    public ArtistEntity setName(ArtistEnum name) {
        this.name = name;
        return this;
    }
}