package ir.man.spring.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*; //click on constraints to see other validation items

@Entity
@Table(name = "product")
@Component
public class Product2 extends SharedMembers<Integer> {
    protected String name;
    protected Boolean activeStatus;

    public Product2() {
    }

    public Product2(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column(name = "name", nullable = false)
    //@NotNull
    @NotBlank // (not null and not blank)
    @Size(min = 3, max = 25,message = "name must between 3 and 25 length")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "activestatus")
    public Boolean getStatus() {
        return activeStatus;
    }

    //@AssertTrue
    //@AssertFalse
    public void setStatus(Boolean status) {
        this.activeStatus = status;
    }

    @Override
    public String toString() {
        return "Product2{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ",status=" + activeStatus +
                '}';
    }
}
