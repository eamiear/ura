package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractPayResult;

/**
 * 二维码链接转成短链接返回结果
 */
public class PayShortUrlResult extends AbstractPayResult {
  private String return_code; // 返回状态码SUCCESS/FAIL

  private String return_msg;// 返回信息
  /**** 以下字段在return_code为SUCCESS的时候有返回 ****/
  private String result_code; // 业务结果 SUCCESS/FAIL
  private String err_code;// 错误返回的信息描述

  private String short_url;

  public String getReturn_code() {
    return return_code;
  }

  public void setReturn_code(String return_code) {
    this.return_code = return_code;
  }

  public String getReturn_msg() {
    return return_msg;
  }

  public void setReturn_msg(String return_msg) {
    this.return_msg = return_msg;
  }

  public String getResult_code() {
    return result_code;
  }

  public void setResult_code(String result_code) {
    this.result_code = result_code;
  }

  public String getErr_code() {
    return err_code;
  }

  public void setErr_code(String err_code) {
    this.err_code = err_code;
  }

  public String getShort_url() {
    return short_url;
  }

  public void setShort_url(String short_url) {
    this.short_url = short_url;
  }
}
