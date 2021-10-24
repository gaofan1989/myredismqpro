package com.gaofan.mqreids.config;

import com.gaofan.mqreids.interceptor.MyHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @author gaofan
 * @create 2021-09-05 22:32
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor()).
                addPathPatterns(Arrays.asList("")).addPathPatterns("/**");
    }
}
