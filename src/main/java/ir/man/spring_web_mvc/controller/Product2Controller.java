package ir.man.spring_web_mvc.controller;

import ir.man.spring.model.Product2;
import ir.man.spring_web_mvc.service.repository.webProductRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/products")
@SessionAttributes("product2") //
public class Product2Controller {

//    @Autowired
//    webProductRepository productRepository;
//
//
//    public Product2Controller(webProductRepository productRepository) {
//        this.productRepository = productRepository;
//        System.out.println("-----------ProductController Instantiated-----------");
//    }
//
////    // *1
////    @ModelAttribute
////    //Or eny other Types
////    public Product2 product2() {
////        System.out.println("-----------new Product2 run by every Request-----------");
////        return new Product2(1, "Computer");
////    }
//
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView products(ModelMap modelMap
//            , @ModelAttribute("message") String message
//            , @ModelAttribute("lastActionOnProduct") String lastActionOnProduct) {
//        //use form 1
//        ModelAndView products_mv = new ModelAndView("product/products");
//        List<Product2> products = productRepository
//                .findAll(PageRequest.of(0, 10, Sort.by("id").ascending())).getContent();
//        products_mv.addObject("Products", products); // in PageContext(Scope) (not RequestScope)
//        modelMap.addAttribute("message", message);
//        modelMap.addAttribute("lastActionOnProduct", lastActionOnProduct);
//        return products_mv;
//    }
//
//    @GetMapping("detail") /* or ("/detail/{id}") */
//    public String productDetail(@RequestParam(value = "pid", required = true) Integer id, ModelMap modelMap
//            , @ModelAttribute("errorsInValidation") ArrayList errors) throws NoSuchElementException
//    // or (@PathVariable Integer id, ModelMap modelMap)
//    {
//        //use form 1
//        Product2 optionalProduct = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
//        modelMap.addAttribute("product", optionalProduct);
//        modelMap.addAttribute("errorsInValidation", errors);
//        return "/product/productDetail";
//    }
//
//    @PostMapping("update")
//    public String updateById(@Valid Product2 product, Errors resultOfValidation, RedirectAttributes redirectAttributes,ModelMap modelMap) {
//        if (resultOfValidation.hasErrors()) {
//            modelMap.addAttribute("errorsInValidation", resultOfValidation.getAllErrors());
//            // ??????  redirectAttributes.addFlashAttribute("testfa" , 154); ?????
//            return "product/productDetail";
//        }
//        productRepository.updateProduct2ById(product.getId(), product.getName(), product.getStatus());
//        //saved in  @ModelAttribute("?") -> message or/and lastActionOnProduct
//        redirectAttributes.addAttribute("message", "this Product updated \n this is a message redirected from previous page");
//        redirectAttributes.addAttribute("lastActionOnProduct", product);
//        return "redirect:/products";
//        // "redirect:/products/detail?pid=" + product.getId();
//    }
//
//    @GetMapping("/pmvariables/{id}")
//    public void checkMatrix(@PathVariable Integer id, @MatrixVariable Integer q1, @MatrixVariable Integer q2, @RequestHeader String headers) {
//        System.out.println("Matrix : " + q1 + ";" + q2 + " -> " + headers);
//    }
//
//    @GetMapping("step1")
//    public String step1() {
//        return "product/step1";
//    }
//
//    // *1
////    @PostMapping("/step2")
////    public String step2(Product2 product2, ModelMap modelMap) {
////        System.out.println("ModelAttribute with Product2 type (top of this page 'if is enable') called : "
////                + product2.getId() + " " + product2.getName());
////        modelMap.addAttribute("product", product2);
////        return "product/step2";
////    }
//
//    @PostMapping("step22")
//    public String step22(Product2 product2, SessionStatus sessionStatus) {
//        System.out.println("ModelSession with Product2 type called : " + product2.getId() + " -- > " + product2.getName());
//        //sessionStatus.setComplete(); // clear the session
//        return "product/step22";
//    }
//
//    @GetMapping("/print")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String printDirectly() {
//        return "<h1><i>this is @ResponseBody (only Controller without a View (Jsp))</i></h1>";
//    }
//
//    // @ControllerAdvice for global error handling :  GlobalExceptionHandlerController here
//    //Or local error handling
//    //@ExceptionHandler(NoSuchElementException.class) // or empty
//    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//
////    public ModelAndView exceptionHandler(NoSuchElementException exception /* base on @ExceptionHandler parameter */, HttpServletRequest servletRequest) {
////        ModelAndView modelAndView = new ModelAndView("notFound");
////        modelAndView.addObject("exception" , exception);
////        modelAndView.addObject("url" , servletRequest.getRequestURL());
////        return modelAndView;
////    }
}
