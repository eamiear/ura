package com.ura.core.resolver;

import com.ura.core.annotation.LoginUser;
import com.ura.core.entity.UserEntity;
import com.ura.core.service.UserService;
import com.ura.core.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
  @Autowired
  private UserService userService;

  @Override
  public boolean supportsParameter(MethodParameter methodParameter) {
    return methodParameter.getParameterType().isAssignableFrom(UserEntity.class)
            && methodParameter.hasParameterAnnotation(LoginUser.class);
  }

  @Override
  public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
    Object object = nativeWebRequest.getAttribute(AuthorizationInterceptor.USER_KEY, RequestAttributes.SCOPE_REQUEST);
    if (object == null) {
      return null;
    }
    return userService.selectById((Long) object);
  }
}
