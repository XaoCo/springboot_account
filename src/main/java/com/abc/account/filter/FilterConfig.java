package com.abc.account.filter;

/**
 * package: com.abc.account.filter
 * auther： abc
 * date: 2019/8/24 10:07
 * introduce: TODO
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

//@Configuration
public class FilterConfig  {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoginFilter());
        registration.addUrlPatterns("/login/*");
        Collection urlPatterns = registration.getUrlPatterns();
        logger.info("路径：",urlPatterns);
        registration.setName(urlPatterns.toString());
        registration.setOrder(1);
        return registration;
    }
}
