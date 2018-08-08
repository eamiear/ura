package com.ura.admin.config;

import com.ura.admin.shiro.RedisShiroSessionDao;
import com.ura.admin.shiro.UserRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
  public SecurityManager securityManager(UserRealm userRealm, SessionManager sessionManager){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(userRealm);
    securityManager.setSessionManager(sessionManager);

    return securityManager;
  }
}
