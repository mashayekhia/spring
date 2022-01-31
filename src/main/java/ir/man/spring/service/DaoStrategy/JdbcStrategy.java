package ir.man.spring.service.DaoStrategy;

import ir.man.spring.model.Product;
import ir.man.spring.model.ProductCategory;
import ir.man.spring.model.interfaces.DaoStrategy;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class JdbcStrategy implements DaoStrategy {

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public JdbcStrategy(Connection connection) {
        this.connection = connection;
        System.out.println("With : JDBC");
    }


    @Override
    public Optional<List<Product>> getAll() throws SQLException {
        preparedStatement = connection.prepareStatement("select p.id as ProductId,p.name as ProductName,c.id as ProductCategoryId,c.name as ProductCategoryName,c.description as ProductCategoryDesc\n" +
                "from Product p,ProductCategory c\n" +
                "where p.category = c.id");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            products.add(Product.builder()
                    .name(resultSet.getString("ProductName"))
                    .productCategory(ProductCategory.builder()
                            .name(resultSet.getString("ProductCategoryName"))
                            .description(resultSet.getString("ProductCategoryDesc"))
                            .build())
                    .build());
        }

        return Optional.ofNullable(products);
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
    public Product delete(Long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Product product) throws SQLException {
        try {
            Objects.requireNonNull(product);
        } catch (NullPointerException ex) {
            return ;
        }
        if (getById(product.getId()).isPresent()) {
            preparedStatement = connection.prepareStatement("DELETE Product WHERE id = ?");
            preparedStatement.setLong(1, product.getId());
            preparedStatement.executeUpdate();
            ////////////////////////////////////connection.commit();
        }
    }

    @Override
    public void releaseConnection() {

    }
}
