package com.ura.admin.aspect;

import com.ura.common.utils.URAException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class RedisAspect {
  private Logger logger = LoggerFactory.getLogger(RedisAspect.class);

  @Value("${ura.redis.open: false}")
  private boolean open;

  @Around("execution(* com.ura.common.utils.RedisUtils.*(..))")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    Object result = null;
    if (open) {
      try {
        result = joinPoint.proceed();
      } catch (Exception e) {
        logger.error("redis error", e);
        throw new URAException("Redis服务异常");
      }

    }
    return result;
  }
}
