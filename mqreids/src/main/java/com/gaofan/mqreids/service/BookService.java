package com.gaofan.mqreids.service;

import com.gaofan.mqreids.entity.BookEntity;
import com.gaofan.mqreids.mapper.BookMapper;
import com.gaofan.mqreids.mapper.UserMapper;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author gaofan
 * @create 2021-05-11 23:27
 */
@Service
public class BookService {



    @DubboReference(async = true)
    @Autowired
    private BookMapper bookMapper;

    @Transactional //加上该注解还是解决不了懒加载的问题，接口返回还是报错 todo
    public BookEntity getOne(Integer id) {
        BookEntity afeafasave = bookMapper.save(null);
        Thread.currentThread().getName();

        return bookMapper.getOne(id);
    }

}
