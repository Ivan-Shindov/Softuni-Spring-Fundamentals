package bg.softuni.Mobilelele.model.binding;

import bg.softuni.Mobilelele.model.enums.EngineEnum;
import bg.softuni.Mobilelele.model.enums.TransmissionEnum;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferAddBindingModel {

    @NotNull
    @Min(1930)
    @Max(2050)
    private Integer year;

    @Positive
    @NotNull
    private Integer mileage;

    @NotNull
    @Min(100)
    private BigDecimal price;

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    public Integer getYear() {
        return year;
    }

    public OfferAddBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferAddBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddBindingModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddBindingModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferAddBindingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
