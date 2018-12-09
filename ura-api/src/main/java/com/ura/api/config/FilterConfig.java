package com.ura.api.config;

import com.ura.common.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean xssFilterRegistration() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
    registrationBean.setFilter(new XssFilter());
    registrationBean.addUrlPatterns("/*");
    registrationBean.setName("xssFilter");
    return registrationBean;
  }
}
