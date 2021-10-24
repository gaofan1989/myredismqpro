package com.gaofan.mqreids.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author gaofan
 * @create 2021-05-25 22:35
 */

@FeignClient(value = "user-server")
public interface UserFeign {
}
