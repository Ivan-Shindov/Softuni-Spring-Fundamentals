package bg.softuni.Mobilelele.entity;

import javax.persistence.*;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(nullable = false,name = "created")
    protected Instant created;

    @Column(name = "modified")
    protected Instant modified;

    public long getId() {
        return id;
    }

    public BaseEntity setId(long id) {
        this.id = id;
        return this;
    }

    @PrePersist
    public void beforeCreate() {
        this.created = Instant.now();
    }

    @PostPersist
    public void onUpdate() {
        this.modified = Instant.now();
    }
}
