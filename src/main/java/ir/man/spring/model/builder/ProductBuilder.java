package ir.man.spring.model.builder;

import ir.man.spring.model.Product;
import ir.man.spring.model.ProductCategory;

public class ProductBuilder extends Product {

    public ProductBuilder id(Long id) {
        super.setId(id);
        return this;
    }

    public ProductBuilder name(String name) {
        super.setName(name);
        return this;
    }

    public ProductBuilder status(Boolean status) {
        super.setStatus(status);
        return this;
    }

    public ProductBuilder productCategory(ProductCategory category) {
        super.setCategory(category);
        return this;
    }

    public Product build() {
        return new Product(id, name, category, activeStatus);
    }
}
