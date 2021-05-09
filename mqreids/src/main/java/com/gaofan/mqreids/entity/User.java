package com.gaofan.mqreids.entity;

import lombok.Data;

/**
 * @author gaofan
 * @create 2021-05-09 23:17
 */
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private String email;
}
