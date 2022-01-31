package ir.man.spring.service.repository;

import ir.man.spring.model.Product;
import ir.man.spring.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    List<Product> findByNameContains(String name);
//
//    List<Product> findByNameIgnoreCaseNotLike(String name);
//
//    List<Product> findByIdIn(Collection IdCollection);
//
//    List<Product> findByStatusFalse();
//
//    List<Product> findByStatusTrue();
//
//    @Transactional
//    @Modifying
//    @Query("update Product p set p.name = ?2 where p.id = ?1")
//    void update(Integer id, String name);
//
//    @Transactional
//    @Modifying
//    @Query("update Product p " +
//            "set p.name = concat(UPPER(SUBSTRING(p.name,1,1)) ,substring(p.name,2,length(p.name) -1 ))"
//            /* + "where (:id is null or p.id = ?1)" */)
//    void toFirstWordUpper();
}
