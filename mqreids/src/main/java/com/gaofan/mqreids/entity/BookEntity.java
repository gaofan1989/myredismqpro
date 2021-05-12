package com.gaofan.mqreids.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author gaofan
 * @create 2021-05-11 22:26
 */
@Proxy(lazy = false)
//@JsonIgnoreProperties(value = { "hibernateLazyInitializer" , "handler"})
@Table(name = "t_book")
@Entity
@Data
public class BookEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String author;

}
