//package ir.man.spring.service.DaoStrategy;
//
//import ir.man.spring.model.interfaces.DaoStrategy;
//import ir.man.spring.model.Product;
//import ir.man.spring.service.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class JpaStrategy implements DaoStrategy {
//
//    private ProductRepository repository;
//
//    public JpaStrategy(ProductRepository repository) {
//        this.repository = repository;
//    }
//
//
//    @Override
//    public Optional<List<Product>> getAll() throws SQLException {
//        List<Product> products = new ArrayList<>();
//        products = repository.findAll();
//        return Optional.ofNullable(products);
//    }
//
//    @Override
//    public Optional<Product> getById(Integer integer) throws SQLException {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Product> S insert(S entity) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public <S extends Product> S update(S entity) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Product delete(Integer integer) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public void delete(Product entity) throws SQLException {
//
//    }
//
//    @Override
//    public void releaseConnection() {
//
//    }
//}
