package ir.man.spring.service.DaoStrategy;

import ir.man.spring.model.interfaces.DaoStrategy;
import ir.man.spring.model.Product;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class HibernateStrategy implements DaoStrategy {

    public HibernateStrategy() {

    }

    @Override
    public Optional<List<Product>> getAll() throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getById(Long integer) throws SQLException {
        return Optional.empty();
    }

    @Override
    public <S extends Product> S insert(S entity) throws SQLException {
        return null;
    }

    @Override
    public <S extends Product> S update(S entity) throws SQLException {
        return null;
    }

    @Override
    public Product delete(Long integer) throws SQLException {
        return null;
    }

    @Override
    public void delete(Product entity) throws SQLException {

    }

    @Override
    public void releaseConnection() {

    }
}
