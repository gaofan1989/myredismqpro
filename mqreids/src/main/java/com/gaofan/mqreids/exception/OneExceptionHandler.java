package com.gaofan.mqreids.exception;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gaofan
 * @create 2021-09-07 22:17
 */
@Order(value = 2)
@RestControllerAdvice
public class OneExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String getExc() {

        return "error";
    }
}


