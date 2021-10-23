package com.example.musicdbapp.model.entity;

import com.example.musicdbapp.model.entity.enums.GenreEnum;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity{

    private String name;
    private String imgUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private GenreEnum genre;
    private ArtistEntity artist;
    private UserEntity addedFrom;

    public AlbumEntity(){

    }

    public String getName() {
        return name;
    }

    public AlbumEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT",name = "image_url",nullable = false)
    public String getImgUrl() {
        return imgUrl;
    }

    public AlbumEntity setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    @Column(columnDefinition = "LONGTEXT",nullable = false)
    public String getDescription() {
        return description;
    }

    public AlbumEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public Integer getCopies() {
        return copies;
    }

    public AlbumEntity setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @Column(nullable = false)
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "release_date",nullable = false)
    @PastOrPresent
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumEntity setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    public ArtistEntity getArtist() {
        return artist;
    }

    public AlbumEntity setArtist(ArtistEntity artis) {
        this.artist = artis;
        return this;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    public UserEntity getAddedFrom() {
        return addedFrom;
    }

    public AlbumEntity setAddedFrom(UserEntity addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }

    @Column
    public String getProducer() {
        return producer;
    }

    public AlbumEntity setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumEntity setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }
}
