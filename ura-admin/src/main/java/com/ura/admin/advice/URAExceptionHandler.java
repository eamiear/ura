/**
 * @author eamiear
 * @date 2018/7/30 16:31
 */

package com.ura.admin.advice;

import com.ura.common.exception.URAException;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class URAExceptionHandler {
  private Logger logger = LoggerFactory.getLogger(getClass());

  @ExceptionHandler(URAException.class)
  public R handleURAException(URAException e) {
    R r = new R();
    r.put("code", e.getCode());
    r.put("msg", e.getMsg());
    logger.error("[URAException] " + e.getMsg(), e);
    return r;
  }

  @ExceptionHandler(DuplicateKeyException.class)
  public R handleDuplicateKeyException(DuplicateKeyException e) {
    logger.error(e.getMessage(), e);
    return R.error(StatusCodeConstant.DATA_DUPLICATE_KEY_IN_DATABASE, "数据库中已存在该记录");
  }

  @ExceptionHandler(AuthorizationException.class)
  public R handleAuthorizationException(AuthorizationException e) {
    logger.error(e.getMessage(), e);
    return R.error(StatusCodeConstant.NO_AUTH, "没有权限");
  }

  @ExceptionHandler(AuthenticationException.class)
  public R handleAuthenticationException(AuthenticationException e) {
    logger.error(e.getMessage(), e);
    return R.error(StatusCodeConstant.TOKEN_EXPIRE, e.getMessage());
  }

  @ExceptionHandler(IncorrectCredentialsException.class)
  public R handleIncorrectCredentialsException(IncorrectCredentialsException e) {
    logger.error(e.getMessage(), e);
    return R.error(StatusCodeConstant.TOKEN_EXPIRE, e.getMessage());
  }

  @ExceptionHandler(LockedAccountException.class)
  public R handleLockedAccountException(LockedAccountException e) {
    logger.error(e.getMessage(), e);
    return R.error(StatusCodeConstant.USER_ACCOUNT_FORBIDDEN, e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public R handleException(Exception e) {
    logger.error(e.getMessage(), e);
    return R.error(StatusCodeConstant.SYSTEM_INNER_ERROR, "系统异常");
  }
}
