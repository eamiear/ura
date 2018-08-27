package com.ura.common.utils;

public class StatusCode {
  // permission
  public static final int NO_AUTH = 1001;         // 无权限
  public static final int TOKEN_EXPIRE = 1002;    // token 失效
  public static final int TOKEN_INVALID = 1003;   // 无效token

  // user about
  public static final int USER_NOT_LOGIN = 2001;  // 用户未登录
  public static final int USER_NOT_EXIST = 2002;  // 用户不存在
  public static final int USER_ACCOUNT_ERROR = 2003;  // 用户名或密码错误
  public static final int USER_ACCOUNT_FORBIDDEN = 2004;  // 用户账号被禁用
  public static final int USER_EXISTED = 2005;    // 用户已存在

  // business about
  public static final int BUSINNESS_ERROR = 3001; // 系统业务出现问题

  // system about
  public static final int SYSTEM_INNER_ERROR = 4001;  // 系统内部错误

  // data about
  public static final int DATA_NOT_FOUND = 5001;  // 数据未找到

  // interface about
  public static final int INTERFACE_INNER_INVOKE_ERROR = 6001;    // 系统内部接口调用错误
  public static final int INTERFACE_OUTER_INVOKE_ERROR = 6002;
  public static final int INTERFACE_FORBIDDEN = 6003; // 接口禁止访问
  public static final int INTERFACE_ADDRESS_INVALID = 6004;   // 接口地址无效
  public static final int INTERFACE_REQUEST_TIMEOUT = 60005;// 接口请求超时

  // params about
  public static final int PARAM_CAPTCHA_ERROR = 7001;
}
