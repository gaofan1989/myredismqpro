package com.gaofan.mqreids.mapper;

import com.gaofan.mqreids.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

/**
 * @author gaofan
 * @create 2021-05-11 22:31
 */
public interface BookMapper extends JpaRepository<BookEntity, Integer> {
}
