package ir.man.spring_web_mvc.controller;

import ir.man.spring.model.Product;
import ir.man.spring.model.ProductCategory;
import ir.man.spring.model.builder.ProductBuilder;
import ir.man.spring.model.builder.ProductCategoryBuilder;
import ir.man.spring.service.repository.ProductCategoryRepository;
import ir.man.spring.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/products")
@SessionAttributes("product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView products(Integer pageNum) {
        float productGroupCount = (productRepository.count() / 10) + ((productRepository.count() % 10) > 0 ? 1 : 0);
        if (pageNum != null)
            if (!pageNum.toString().matches("\\d+") || pageNum == 0 && pageNum > productGroupCount) {
                pageNum = null;
            }
        List<Product> products = productRepository.findAll(PageRequest.of(pageNum != null ? pageNum - 1 : 0, 10, Sort.by("id"))).toList();

        // ابتدا در فایل کانفیگ tile
        // به دنبال prods
        //می گردد و اگر نبود از viewResolver
        // پیش فرض آن را جستجو می کند
        // و باید به فرم
        // /product/prods
        // باشد
        ModelAndView modelAndView = new ModelAndView("prods");

        modelAndView.addObject("Products", products);
        modelAndView.addObject("productGroupCount", productGroupCount);
        return modelAndView;
    }

    @GetMapping("/{pageNum:\\d+}")
    public ModelAndView productsPage(@PathVariable Integer pageNum, ModelMap modelMap) {
        System.out.println("---------------");
        modelMap.addAttribute("pageNum", pageNum);
        return products(pageNum);
    }

    @GetMapping("new")
    public String newProduct(@RequestParam("step") Integer stepNum) {
        // ابتدا در فایل کانفیگ tile
        // به دنبال prods
        //می گردد و اگر نبود از viewResolver
        // پیش فرض آن را جستجو می کند
        // و باید به فرم
        // /product/step
        // باشد
        System.out.println("in Step top");
        return "step" + stepNum;
    }

    @PostMapping("/new")
    public String newStep(Product p, ProductCategory c, @RequestParam("step") Integer stepNum) {
        switch (stepNum) {
            case 2: {
                System.out.println("in Step ! " + stepNum);
                System.out.println(p);
                System.out.println(c);
                Product product = ProductBuilder.builder().name(p.getName()).status(true).build();
                System.out.println(product);
                break;
            }
            case 3: {
                System.out.println("in Step !! " + stepNum);
                System.out.println(p);
                System.out.println(c);
                System.out.println("Count : " + categoryRepository.count());
                // ProductCategory productCategory = categoryRepository.findByName("A");
                //  System.out.println(productCategory);
                break;
            }

        }
        return newProduct(stepNum);
    }

    @GetMapping("test")
    public String getSecs() {
        return "sec_type_1/sec_t1-tile";
    }
}
