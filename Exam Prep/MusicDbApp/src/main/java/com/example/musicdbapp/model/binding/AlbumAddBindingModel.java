package com.example.musicdbapp.model.binding;

import com.example.musicdbapp.model.entity.enums.ArtistEnum;
import com.example.musicdbapp.model.entity.enums.GenreEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

    private String name;
    private String imgUrl;
    private String description;
    private Integer copies;
    private Double price;
    private LocalDate releasedDate;
    private String producer;
    private GenreEnum genre;
    private ArtistEnum artist;

    public AlbumAddBindingModel(){

    }

    @NotBlank
    @Size(min = 3,max = 20)
    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank
    @Size(min = 5)
    public String getImgUrl() {
        return imgUrl;
    }

    public AlbumAddBindingModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    @NotBlank
    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    @Min(10)
    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumAddBindingModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    @NotBlank
    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @NotNull
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @NotNull
    public ArtistEnum getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }


    @NotNull
    @Positive
    public Double getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(Double price) {
        this.price = price;
        return this;
    }
}
