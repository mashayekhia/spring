package ir.man.spring.model.builder;

import ir.man.spring.model.ProductCategory;

public class ProductCategoryBuilder extends ProductCategory {

    public ProductCategoryBuilder id(Long id) {
        super.setId(id);
        return this;
    }

    public ProductCategoryBuilder name(String name) {
        super.name = name;
        return this;
    }

    public ProductCategoryBuilder description(String description) {
        super.description = description;
        return this;
    }

    public ProductCategory build() {
        return new ProductCategory(id, name, description);
    }
}
