package ir.man.spring.model;

import ir.man.spring.model.builder.ProductCategoryBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "ProductCategory")
@Component("product_category")
public class ProductCategory {

    protected Long id;
    protected String name;
    protected String description;
    protected List<Product> products;

    public ProductCategory() {
    }

    public ProductCategory(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Id
    @Column(name = "pcid", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", unique = true, nullable = false)
    @Size(min = 3, max = 100, message = "Die Lände des Productnames müssten ywischen 3 und 100 liegen")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    @Size(max = 250, message = "Die maximale Länge des Producktbeschreibung müssten 250 liegen")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static ProductCategoryBuilder builder() {
        return new ProductCategoryBuilder();
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }
}
