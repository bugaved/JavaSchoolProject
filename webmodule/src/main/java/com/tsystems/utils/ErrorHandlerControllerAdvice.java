package com.tsystems.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bugav on 12.10.2017.
 */
@ControllerAdvice
public class ErrorHandlerControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handle(Exception ex) {
        ModelAndView errorPage = new ModelAndView("errorPage.jsp");
        errorPage.addObject("errorMessage", ex.getMessage());
        return errorPage;
    }
}
