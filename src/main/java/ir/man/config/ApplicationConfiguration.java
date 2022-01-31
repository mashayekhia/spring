package ir.man.config;

import ir.man.spring.service.ConnectionPool;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@ComponentScan("ir.man.spring")
public class ApplicationConfiguration {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        ConnectionPool connection = ConnectionPool.connectionPoolInstantiate
                ("jdbc:sqlserver://DESKTOP-GCBNIVU\\INS2014ENT;databaseName=Products", "sqluser", "123");
        return connection.getConnection();
    }

}
