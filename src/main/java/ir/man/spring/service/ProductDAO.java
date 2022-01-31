package ir.man.spring.service;

import ir.man.spring.model.interfaces.DaoStrategy;
import ir.man.spring.model.interfaces.IDao;
import ir.man.spring.model.interfaces.Secured;
import ir.man.spring.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Component
@Secured
public class ProductDAO implements IDao<Product, Integer> {

    private DaoStrategy daoStrategy;

    public ProductDAO(@Qualifier("jdbcStrategy") DaoStrategy daoStrategy) {
        this.daoStrategy = daoStrategy;
        System.out.println("ok");
    }

    @Override
    public Optional<List<Product>> getAll() throws SQLException {
        return daoStrategy.getAll();
    }

    @Override
    public Optional<Product> getById(Integer integer) throws SQLException {
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
    public Product delete(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public void delete(Product entity) throws SQLException {

    }

    @Override
    public void releaseConnection() {

    }
}
