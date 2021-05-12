package com.gaofan.mqreids.controller;

import com.alibaba.fastjson.JSON;
import com.gaofan.mqreids.entity.BookEntity;
import com.gaofan.mqreids.mapper.BookMapper;
import com.gaofan.mqreids.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author gaofan
 * @create 2021-05-11 22:31
 */
@Slf4j
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/getById")
    public BookEntity getById(@RequestParam(name = "id") Integer id) {
        BookEntity one = bookMapper.getOne(id);
        //log.info("entity的类型---> {}，BookEntity  --- > {}" , one.getClass().getName(), JSON.toJSONString(one));
        log.info("entity的类型---> {}，BookEntity  --- > book" , one.getClass().getName());
        return one;
    }

    @RequestMapping("/getById3")
    public BookEntity getById3(@RequestParam(name = "id") Integer id) {
        BookEntity one = bookService.getOne(id);
        //log.info("entity的类型---> {}，BookEntity  --- > {}" , one.getClass().getName(), JSON.toJSONString(one));
        log.info("entity的类型---> {}，BookEntity  --- > book.name: {}" , one.getClass().getName(), one.getName());
        return one;
    }


    @RequestMapping("/getById2")
    public BookEntity getById2(@RequestParam(name = "id") Integer id) {
        Optional<BookEntity> one = bookMapper.findById(id);
        if(one.isPresent()){
            log.info("entity的类型---> {}，BookEntity  --- > {}" , one.get().getClass().getName(), JSON.toJSONString(one.get()));
            return one.get();
        }
        return null;
    }

}
