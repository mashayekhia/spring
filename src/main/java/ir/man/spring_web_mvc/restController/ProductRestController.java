package ir.man.spring_web_mvc.restController;

import com.fasterxml.jackson.annotation.JsonView;
import ir.man.spring.model.Product;
import ir.man.spring.model.builder.ProductBuilder;
import ir.man.spring.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/product-api" , produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    @ResponseBody
    @JsonView(Product.JsonProductGeneralView.class)
    public List<Product> getProductCategories() {
        return Arrays.asList(ProductBuilder.builder().id(1L).name("Computer").build(),ProductBuilder.builder().id(2L).name("Case").build());
    }

    @GetMapping("ajaxProds") // ajaxProds (.jsp)
    public String getProdsWithAjax() {
        return "product/ajaxProds";
    }

    @PostMapping(value = "ajaxProds" , produces = MediaType.APPLICATION_JSON_VALUE /*get*/
            , consumes = MediaType.APPLICATION_JSON_VALUE) /*when post*/ // ajaxProds (.jsp)
    public void save(@RequestBody Product product) {
        System.out.println(product + " saved");
    }
}
