package ir.man.spring_web_mvc.service.repository;

import ir.man.spring.model.Product2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface webProductRepository extends JpaRepository<Product2, Integer> {
    @Transactional
    @Modifying
    @Query("update Product2 p set p.name = ?2 , p.status = ?3 where p.id = ?1")
    int updateProduct2ById(Integer id, String name, Boolean status);
}
