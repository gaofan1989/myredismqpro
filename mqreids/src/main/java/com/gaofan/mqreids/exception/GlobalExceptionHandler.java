package com.gaofan.mqreids.exception;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gaofan
 * @create 2021-09-07 22:12
 */
@Order(value = 1)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public String getExe(HttpServletRequest request, BusinessException be) {
        //todo 自己的业务逻辑
        System.out.println("自己的业务逻辑");
        return "failure";
    }
}
