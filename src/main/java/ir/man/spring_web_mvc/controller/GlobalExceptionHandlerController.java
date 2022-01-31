package ir.man.spring_web_mvc.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView notFound(ServiceException exception, HttpServletRequest servletRequest) {
        ModelAndView modelAndView = new ModelAndView("notFound");
//        Map<String,Object> exceptionMap = new HashMap();
//        exceptionMap.put("url",servletRequest.getRequestURL());
//        exceptionMap.put("exception",exception);
//        modelAndView.addAllObjects(exceptionMap);
        modelAndView.addObject("exception" , exception);
        modelAndView.addObject("url" , servletRequest.getRequestURL());
        return modelAndView;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String error() {
        return "page Not Found";
    }
}
