package bg.softuni.Mobilelele.model.service;

public class BrandServiceSelectModel {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public BrandServiceSelectModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandServiceSelectModel setName(String name) {
        this.name = name;
        return this;
    }
}
