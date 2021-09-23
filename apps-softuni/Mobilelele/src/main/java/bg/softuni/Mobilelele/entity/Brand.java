package bg.softuni.Mobilelele.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private Set<Model> models;

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }
}
