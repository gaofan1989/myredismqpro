package com.gaofan.mqreids.config;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;

/**
 * @author gaofan
 * @create 2021-05-12 23:16
 */
@Configuration
public class DruidConfig {

    //@Bean
    public ServletRegistrationBean statViewServletRegistrationBean2() {
        ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        servletServletRegistrationBean.setServlet(new StatViewServlet());
//        servletServletRegistrationBean.addUrlMappings("/druid/*");
        servletServletRegistrationBean.addInitParameter("allow","");

        return servletServletRegistrationBean;
    }

    //@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/");
        filterRegistrationBean.addUrlPatterns("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }

}
