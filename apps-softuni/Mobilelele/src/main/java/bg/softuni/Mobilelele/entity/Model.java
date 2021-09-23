package bg.softuni.Mobilelele.entity;

import bg.softuni.Mobilelele.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{

    @Column
    private String name;

    @Enumerated
    private CategoryEnum category;

    @Column(length = 512)
    private String imageUrl;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    @ManyToOne
    private Brand brand;
}

