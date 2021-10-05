package bg.softuni.Mobilelele.entity;

import bg.softuni.Mobilelele.entity.enums.EngineEnum;
import bg.softuni.Mobilelele.entity.enums.TransmissionEnum;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private EngineEnum engine;

    @Column
    private String imageUrl;

    @Column
    private BigDecimal price;

    @Column(nullable = false)
    private TransmissionEnum transmission;

    @Column(length = 4)
    private int year;

    @ManyToMany()
    private Set<Model> models;

    @ManyToOne
    private User seller;

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public Offer setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Offer setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public Offer setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Offer setYear(int year) {
        this.year = year;
        return this;
    }

    public Set<Model> getModels() {
        return models;
    }

    public Offer setModels(Set<Model> models) {
        this.models = models;
        return this;
    }

    public User getSeller() {
        return seller;
    }

    public Offer setSeller(User seller) {
        this.seller = seller;
        return this;
    }
}
