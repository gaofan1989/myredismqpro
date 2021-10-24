package com.gaofan.mqreids.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gaofan
 * @create 2021-05-25 22:28
 */
@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        //线程1先获取requestAttributes
        //RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //线程2set attr 可以通过该方法在不同线程中共享 requestAttributes
        //RequestContextHolder.setRequestAttributes(requestAttributes);
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = servletRequestAttributes.getRequest();

                template.header("Cookie", request.getHeader("Cookie"));
            }
        };
    }


    @Bean
    public RequestInterceptor requestInterceptor2() {
        return (template) ->  {
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = servletRequestAttributes.getRequest();
                template.header("Cookie", request.getHeader("Cookie"));
        };
    }

}
