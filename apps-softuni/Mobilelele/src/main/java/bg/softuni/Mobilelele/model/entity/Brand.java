package bg.softuni.Mobilelele.model.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "brand",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Model> models;

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Model> getModels() {
        return models;
    }

    public Brand setModels(Set<Model> models) {
        this.models = models;
        return this;
    }
}
