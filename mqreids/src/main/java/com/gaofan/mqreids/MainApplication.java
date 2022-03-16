package com.gaofan.mqreids;

import com.gaofan.mqreids.entity.BookEntity;
import com.gaofan.mqreids.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaofan
 * @create 2021-12-05 23:14
 */
public class MainApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        BookService bean = applicationContext.getBean(BookService.class);
        BookEntity one = bean.getOne(3);
        System.out.println(one);
    }
}
