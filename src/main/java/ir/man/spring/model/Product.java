package ir.man.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import ir.man.spring.model.builder.ProductBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Product")
@Component
public class Product {
    protected Long id;
    protected String name;
    protected Boolean activeStatus;
    protected ProductCategory category;

    public Product() {
    }

    public Product(Long id, String name, ProductCategory category, Boolean status) {
        this.id = id;
        this.name = name;
        this.activeStatus = status;
        this.category = category;
    }

    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonProductGeneralView.class)
    @JsonProperty("ProdId")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", unique = true, nullable  = false)
    @NotBlank // اگر پارامتر group
    // را به یک اینترفیس نسبت دهیم مانند JsonView
    //هم میتوانیم برای یک متد از کنتر این محدودیت اعمال شود و برای دیگری نه
    @Size(min = 3, max = 100, message = "Die Länge des Productnames müssten zwischen 3 und 100 liegen")
    @JsonView(JsonProductGeneralView.class) // دراین صورت در متد موجود در کنترلر این اینترفیس را به عنوان ویو معرفی کنید
    // تا آن پروپرتی هایی که این ویو را بالای خود معرفی کرده اند دیده شوند فقط
    @JsonProperty("ProdName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = false)
    // در لیست خروجی جیسون نمی آورد
    // اولویت بالاتری نسبت به JsonView دارد
    @JsonIgnore
    @JsonView(JsonProductGeneralView.class)
    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Column(name = "activestatus")
    @JsonProperty("ProdStateus")
    public Boolean getStatus() {
        return activeStatus;
    }

    //@AssertTrue
    //@AssertFalse
    public void setStatus(Boolean status) {
        this.activeStatus = status;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activeStatus=" + activeStatus +
                ", category=" + category +
                '}';
    }

    public interface JsonProductGeneralView {
    }

}
