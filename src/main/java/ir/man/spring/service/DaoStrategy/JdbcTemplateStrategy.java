package ir.man.spring.service.DaoStrategy;

import ir.man.spring.model.ProductCategory;
import ir.man.spring.model.interfaces.DaoStrategy;
import ir.man.spring.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class JdbcTemplateStrategy implements DaoStrategy {

    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    public JdbcTemplateStrategy(JdbcTemplate jdbcTemplate, PlatformTransactionManager platformTransactionManager) throws SQLException, ClassNotFoundException {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setTimeout(30); // second
        System.out.println("With : jdbcTemplate");
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Product>> getAll() throws SQLException {
        //transactionTemplate.execute(status -> {
        List<Product> products = jdbcTemplate.query("select p.id as ProductId,p.name as ProductName,c.id as ProductCategoryId,c.name as ProductCategoryName,c.description as ProductCategoryDesc\n" +
                "from Product p,ProductCategory c\n" +
                "where p.category = c.id", (rs, rowNum) -> Product.builder().id(rs.getLong("ProductId"))
                .name(rs.getString("ProductName"))
//                .productCategory(ProductCategory.builder().id(rs.getInt("ProductCategoryId"))
//                        .name(rs.getString("ProductCategoryName")).description(rs.getString("ProductCategoryDesc")))
                .build()
        );
        // return products;
        // });
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
