package com.gaofan.mqreids.controller;

import com.gaofan.mqreids.entity.User;
import com.gaofan.mqreids.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gaofan
 * @create 2021-10-30 23:51
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    @GetMapping("/getByName")
    public List<User> getByName(@RequestParam("name") String name) {

        User user = new User();
        user.setUsername(name);
        List<User> all = userMapper.getAll(user);
        return all;
    }
}
