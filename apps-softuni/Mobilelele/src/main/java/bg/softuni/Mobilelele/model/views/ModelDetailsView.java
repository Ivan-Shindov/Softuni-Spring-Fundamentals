package bg.softuni.Mobilelele.model.views;

import bg.softuni.Mobilelele.model.entity.BaseEntity;
import bg.softuni.Mobilelele.model.enums.EngineEnum;
import bg.softuni.Mobilelele.model.enums.TransmissionEnum;

import java.math.BigDecimal;
import java.time.Instant;

public class ModelDetailsView extends BaseEntity {

    private long id;
    private int year;
    private String brandName;
    private String modelName;
    private int mileage;
    private BigDecimal price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private String description;
    private String seller;
    private Instant created;
    private Instant modified;
    private String image;

    public ModelDetailsView(){}


    public int getYear() {
        return year;
    }

    public ModelDetailsView setYear(int year) {
        this.year = year;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public ModelDetailsView setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public ModelDetailsView setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public ModelDetailsView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ModelDetailsView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public ModelDetailsView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public ModelDetailsView setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public ModelDetailsView setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public ModelDetailsView setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public ModelDetailsView setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getImage() {
        return image;
    }

    public ModelDetailsView setImage(String image) {
        this.image = image;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ModelDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public ModelDetailsView setId(long id) {
        this.id = id;
        return this;
    }
}
