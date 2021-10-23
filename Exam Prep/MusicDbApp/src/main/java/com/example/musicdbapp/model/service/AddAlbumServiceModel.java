package com.example.musicdbapp.model.service;

import com.example.musicdbapp.model.entity.enums.ArtistEnum;
import com.example.musicdbapp.model.entity.enums.GenreEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddAlbumServiceModel {

    private Long id;
    private String name;
    private String imgUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private GenreEnum genre;
    private ArtistEnum artist;

    public AddAlbumServiceModel() {

    }

    public Long getId() {
        return id;
    }

    public AddAlbumServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddAlbumServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public AddAlbumServiceModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddAlbumServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AddAlbumServiceModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddAlbumServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AddAlbumServiceModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AddAlbumServiceModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public AddAlbumServiceModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    public ArtistEnum getArtist() {
        return artist;
    }

    public AddAlbumServiceModel setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }
}
