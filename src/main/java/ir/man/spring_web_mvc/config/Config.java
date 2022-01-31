package ir.man.spring_web_mvc.config;

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
public class Config {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        System.out.println("-----Tiles Configuration");
        final TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("WEB-INF/view/jsp/tiles/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        System.out.println("-----Tiles viewResolver");
        final TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        // اولویت بیشتر نسبت به viewResolver
        // پیش فرض
        tilesViewResolver.setOrder(1);
        return tilesViewResolver;
    }
}
