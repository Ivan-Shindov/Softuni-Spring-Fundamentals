package bg.softuni.Mobilelele.entity;

import bg.softuni.Mobilelele.entity.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }

    public Role setRole(RoleEnum role) {
        this.role = role;
        return this;
    }

    public long getId() {
        return id;
    }

    public Role setId(long id) {
        this.id = id;
        return this;
    }
}
