package ir.man.spring;

import ir.man.spring.model.Product2;
import ir.man.spring.service.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class ApplicationTests {

    @Autowired
    //ProductRepository productRepository;

    @Test
    void contextLoads() {

    }

    @Test
    void findAll_Sort_Pageable_ExampleMatch() {
//        String spring_logo = "  .   ____          _            __ _ _\n" +
//                " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\\n" +
//                "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\\n" +
//                " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )\n" +
//                "  '  |____| .__|_| |_|_| |_\\__, | / / / /\n" +
//                " =========|_|==============|___/=/_/_/_/";
//
//        //Sorting
//        productRepository.findAll(Sort.by("id").ascending())
//                .forEach(System.out::println);
//        System.out.println("-----------------------------------");
//
//        //Pagination
//        productRepository.findAll(Pageable.ofSize(2))
//                .forEach(System.out::println);
//        System.out.println("-----------------------------------");
//
//        Page<Product2> product2s =
//                productRepository.findAll(PageRequest.of(0, 2, Sort.by("id").ascending()));
//        product2s.forEach(System.out::println);
//        System.out.println("-----------------------------------");
//
//        List<Product2> product2s1 = productRepository.findAll(PageRequest.of(1, 2, Sort.by("id").ascending()))
//                .stream().map(product2 -> new Product2(product2.getId(), product2.getName())).collect(Collectors.toList());
//        product2s1.forEach(System.out::println);
//        System.out.println("-----------------------------------");
//
//        //Example
//        Product2 product2Example = new Product2(3, "notebook ");
//        productRepository.findAll(Example.of(product2Example))
//                .forEach(System.out::println);
//        System.out.println("-----------------------------------");
//
//        System.out.println(spring_logo);
    }

    @Test
    void QueryProduction() {
//        List<Product2> tq1 = productRepository.findByNameContains("t");
//        tq1.forEach(System.out::println);
//        System.out.println("------------------------");
//        List<Product2> tq2 = productRepository.findByNameIgnoreCaseNotLike("%oo%");
//        tq2.forEach(System.out::println);
//        System.out.println("------------------------");
//        List<Product2> tq3 = productRepository.findByIdIn(List.of(1, 5));
//        tq3.forEach(System.out::println);
//        System.out.println("------------------------");
//        List<Product2> tq4 = productRepository.findByStatusFalse();
//        tq4.forEach(System.out::println);
//        System.out.println("------------------------");
//        List<Product2> tq5 = productRepository.findByStatusTrue();
//        tq5.forEach(System.out::println);
//        System.out.println("------------------------");
//        productRepository.update(1, "book");
//        productRepository.update(3, "notebook");
//        productRepository.update(4, "t-shirt");
//        productRepository.update(5, "computer");
//        productRepository.toFirstWordUpper();
//        productRepository.findAll().forEach(System.out::println);
    }

}
