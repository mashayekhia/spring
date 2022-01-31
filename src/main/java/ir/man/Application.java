package ir.man;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.Properties;

import java.sql.SQLException;

@SpringBootApplication
@ComponentScan(value = "ir.man.spring_web_mvc")
public class Application  /*تمام متدهای بین را اجرا می کند*/ {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("-------------------------In Main Method : " + context.getEnvironment());
    }

    @Bean
    ApplicationRunner applicationRunner(Environment environment, ConfigurableEnvironment configurableEnvironment) {
        //From java.util.Properties
        //Properties properties = new Properties();
        //properties.

        //Or From java.util.Map

        //Or From Environment(Java System/environment) properties
        //set in Run->Edit Configuration

        return args -> {
            configurableEnvironment.setActiveProfiles("prod");
                configurableEnvironment.getSystemEnvironment().forEach((s, o) -> {
                    System.out.println(s + ":" + o);
                });
            System.out.println("----------------------------------------------------------------------------------------------");
                configurableEnvironment.getSystemProperties().forEach((s, o) -> {
                    System.out.println(s + ":" + o);
                });
            System.out.println(">" + environment.acceptsProfiles(activeProfiles -> activeProfiles.test("dev")));
            System.out.println(">> In ApplicationRunner Method");
            System.out.println(String.format("application-%s.configuration with Name: %s  Description: %s Message: %s"
                    , environment.getActiveProfiles()[0]
                    , environment.getProperty("app.name")
                    , environment.getProperty("app.description")
                    , environment.getProperty("app.message")));
            System.out.println(">>> " + environment.getProperty("JAVA_HOME"));
        };
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("-------------------------In Run Method");
//    }

    @Bean
    public void print() {
        System.out.println("-------------------------In Print Method");
    }

    @Bean
    public void Message() {
        System.out.println("-------------------------In Message Method");
    }
}
