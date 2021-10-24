package com.gaofan.mqreids.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author gaofan
 * @create 2021-05-25 23:11
 */
@Configuration
public class MyTreadConfig {


    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return null;
        //return new ThreadPoolExecutor();
    }

}


