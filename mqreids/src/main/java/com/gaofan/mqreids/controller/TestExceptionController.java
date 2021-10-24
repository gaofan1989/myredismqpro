package com.gaofan.mqreids.controller;

import com.gaofan.mqreids.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaofan
 * @create 2021-09-07 22:18
 */
@RestController
@RequestMapping("/test/exception")
public class TestExceptionController {

    @GetMapping("/getOne")
    public String getOne() throws Exception {
        String str = "abcde";
        if (str.length() == 5) {
            throw new Exception(str);
        }
        return "not Null";
    }


}
