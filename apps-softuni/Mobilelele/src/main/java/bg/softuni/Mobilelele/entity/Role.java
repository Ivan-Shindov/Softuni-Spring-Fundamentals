package bg.softuni.Mobilelele.entity;

import bg.softuni.Mobilelele.entity.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;
}
