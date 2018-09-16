package com.ura.api.interceptor;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.api.annotation.Login;
import com.ura.api.entity.TokenEntity;
import com.ura.api.service.TokenService;
import com.ura.common.exception.URAException;
import com.ura.common.utils.StatusCodeConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token验证
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter{
  @Autowired
  private TokenService tokenService;

  public static final String USER_KEY = "userId";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    IgnoreAuth annotation;
    if (handler instanceof HandlerMethod) {
      annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
    } else {
      return true;
    }
    // 如果有@IgnoreAuth注解，则不校验token
    if (annotation == null) {
      return true;
    }
    String token = request.getHeader("token");
    if (StringUtils.isBlank(token)) {
      token = request.getParameter("token");
    }

    if (StringUtils.isBlank(token)) {
      throw new URAException("token不能为空", StatusCodeConstant.TOKEN_INVALID);
    }

    TokenEntity tokenEntity = tokenService.queryByToken(token);
    if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
      throw new URAException("token失效，请重新登录", StatusCodeConstant.TOKEN_EXPIRE);
    }
    request.setAttribute(USER_KEY, tokenEntity.getUserId());

    return true;
  }
}
