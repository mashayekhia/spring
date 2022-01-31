package ir.man.spring.service.repository;

import ir.man.spring.model.Product;
import ir.man.spring.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
