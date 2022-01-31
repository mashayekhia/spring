package ir.man.spring.service;

import ir.man.spring.model.interfaces.IConnectionPool;
import ir.man.spring.model.interfaces.IDao;
import ir.man.spring.model.ProductCategory;
import ir.man.spring.model.interfaces.Secured;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Secured
public class ProductCategoryDAO implements IDao<ProductCategory, Integer> {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    ///////////////////////////////////////////////////////////
    private long skip;

    public ProductCategoryDAO(Connection connection) throws SQLException, ClassNotFoundException {
        this.connection = connection;
    }

    @Override
    public Optional<List<ProductCategory>> getAll() throws SQLException {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ProductCategory");
        List<ProductCategory> productCategories = new ArrayList<>();
        while (resultSet.next())
            productCategories.add(ProductCategory.builder()
                    .name(resultSet.getString("name"))
                    .description(resultSet.getString("description")).build());

        return Optional.ofNullable(productCategories);
    }

    @Override
    public Optional<ProductCategory> getById(Integer integer) throws SQLException {
        return Optional.empty();
    }

    @Override
    public <S extends ProductCategory> S insert(S entity) throws SQLException {
        return null;
    }

    @Override
    public <S extends ProductCategory> S update(S entity) throws SQLException {
        return null;
    }

    @Override
    public ProductCategory delete(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public void delete(ProductCategory entity) throws SQLException {

    }

    @Override
    public void releaseConnection() {

    }
}
