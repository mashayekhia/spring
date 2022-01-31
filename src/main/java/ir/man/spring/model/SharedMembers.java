package ir.man.spring.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@MappedSuperclass
public abstract class SharedMembers<ID extends Serializable> {
    protected ID id;

    public void setId(ID id) {
        this.id = id;
    }

    @Id
    @Column(name = "id",insertable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public ID getId() {
        return id;
    }

}
