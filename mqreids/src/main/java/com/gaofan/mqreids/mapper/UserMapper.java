package com.gaofan.mqreids.mapper;

import com.gaofan.mqreids.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gaofan
 * @create 2021-05-09 23:11
 */
@Mapper
public interface UserMapper {

    User getById(Integer id);
}
