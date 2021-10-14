package bg.softuni.Mobilelele.model.service;

import bg.softuni.Mobilelele.model.enums.EngineEnum;
import bg.softuni.Mobilelele.model.enums.TransmissionEnum;

import java.math.BigDecimal;
import java.time.Instant;

public class OfferUpdateServiceModel {

    private long id;
    private int year;
    private int mileage;
    private BigDecimal price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private String description;
    private Instant modified;
    private String image;

    public long getId() {
        return id;
    }

    public OfferUpdateServiceModel setId(long id) {
        this.id = id;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferUpdateServiceModel setYear(int year) {
        this.year = year;
        return this;
    }



    public int getMileage() {
        return mileage;
    }

    public OfferUpdateServiceModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferUpdateServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferUpdateServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferUpdateServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferUpdateServiceModel setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getImage() {
        return image;
    }

    public OfferUpdateServiceModel setImage(String image) {
        this.image = image;
        return this;
    }
}
