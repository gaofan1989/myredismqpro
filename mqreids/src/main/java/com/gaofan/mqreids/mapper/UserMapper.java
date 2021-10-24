package com.gaofan.mqreids.mapper;

import com.gaofan.mqreids.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaofan
 * @create 2021-05-09 23:11
 */
@Repository
@Mapper
public interface UserMapper {

    User getById(Integer id);

    List<User> getAll(User user);
}
