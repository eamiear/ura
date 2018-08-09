package com.ura.admin.config;

import com.ura.admin.oauth2.OAuth2Filter;
import com.ura.admin.oauth2.OAuth2Realm;
import com.ura.admin.shiro.RedisShiroSessionDao;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

  @Bean("sessionManager")
  public SessionManager sessionManager(RedisShiroSessionDao redisShiroSessionDao,
                                       @Value("${ura.redis.open}") boolean redisOpen,
                                       @Value("${ura.shiro.redis}") boolean shiroRedis){
    DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
    sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
    sessionManager.setSessionValidationSchedulerEnabled(true);
    sessionManager.setSessionIdUrlRewritingEnabled(false);

    if (redisOpen && shiroRedis){
      sessionManager.setSessionDAO(redisShiroSessionDao);
    }

    return sessionManager;
  }

  @Bean("securityManager")
  public SecurityManager securityManager(OAuth2Realm oAuth2Realm, SessionManager sessionManager){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(oAuth2Realm);
    securityManager.setSessionManager(sessionManager);

    return securityManager;
  }

  @Bean("shiroFilter")
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
    ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
    shiroFilter.setSecurityManager(securityManager);

    Map<String, Filter> filters = new HashMap<>();
    filters.put("oauth2", new OAuth2Filter());
    shiroFilter.setFilters(filters);

    Map<String, String> filterMap = new LinkedHashMap<>();
    filterMap.put("/webjars/**", "anon");
    filterMap.put("/druid/**", "anon");
    filterMap.put("/sys/login**", "anon");
    filterMap.put("/swagger/**", "anon");
    filterMap.put("/v2/api-docs", "anon");
    filterMap.put("/swagger-ui.html", "anon");
    filterMap.put("/captcha.jpg", "anon");

    filterMap.put("/**", "oauth2");

    shiroFilter.setFilterChainDefinitionMap(filterMap);
    return shiroFilter;
  }

  @Bean("lifecycleBeanPostProcessor")
  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
    return new LifecycleBeanPostProcessor();
  }

  @Bean("authorizationAttributeSourceAdvisor")
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
    AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }

}
