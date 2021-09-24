package bg.softuni.Mobilelele.entity;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(nullable = false)
    protected Instant created;

    @Column(nullable = false)
    protected Instant modified;

    public long getId() {
        return id;
    }

    public BaseEntity setId(long id) {
        this.id = id;
        return this;
    }
}
