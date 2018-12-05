package com.ura.common.utils;

public class StatusCodeConstant {
  // permission
  public static final int NO_AUTH = 1004;         // 无权限
  public static final int TOKEN_EXPIRE = 1002;    // token 失效
  public static final int TOKEN_INVALID = 1003;   // 无效token
  public static final int TOKEN_OAUTH_ERROR = 1004; // 微信授权失败

  // user about
  public static final int USER_NOT_LOGIN = 2001;  // 用户未登录
  public static final int USER_NOT_EXIST = 2002;  // 用户不存在
  public static final int USER_ACCOUNT_ERROR = 2003;  // 用户名或密码错误
  public static final int USER_ACCOUNT_FORBIDDEN = 2004;  // 用户账号被禁用
  public static final int USER_EXISTED = 2005;    // 用户已存在

  // business about
  public static final int BUSINESS_ERROR = 3001; // 系统业务出现问题
  public static final int BUSINESS_PAY_SUCCESS = 3010;  // 支付成功
  public static final int BUSINESS_PAY_ERROR = 3011;    // 支付失败
  public static final int BUSINESS_PAY_EXCEPTION = 3012;    // 支付异常


  // system about
  public static final int SYSTEM_INNER_ERROR = 4001;  // 系统内部错误

  // data about
  public static final int DATA_NOT_FOUND = 5001;  // 数据未找到
  public static final int DATA_DUPLICATE_KEY_IN_DATABASE = 5002; // 数据库记录重复
  public static final int DATA_CREATE_ERROR = 5003; // 数据创建失败

  // interface about
  public static final int INTERFACE_INNER_INVOKE_ERROR = 6001;    // 系统内部接口调用错误
  public static final int INTERFACE_OUTER_INVOKE_ERROR = 6002;
  public static final int INTERFACE_FORBIDDEN = 6003; // 接口禁止访问
  public static final int INTERFACE_ADDRESS_INVALID = 6004;   // 接口地址无效
  public static final int INTERFACE_REQUEST_TIMEOUT = 60005;// 接口请求超时

  // params about
  public static final int PARAM_CAPTCHA_ERROR = 7001;
  public static final int PARAM_NOT_EMPTY = 7002; // 参数不能为空
  public static final int PARAM_SIZE_INVALID = 7003; //参数长度不对

  //
  public static final int THIRD_INTERFACE_ERROR = 8001;
  public static final int THIRD_INTERFACE_EXCEPTION = 8002;
  public static final int THIRD_INTERFACE_NODATA = 8003;
}
