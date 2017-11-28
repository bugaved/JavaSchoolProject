package com.tsystems.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Manages error handler, redirects to error page
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
