package com.ura.wechat.model.resp;

import com.ura.wechat.model.req.JsPayParams;

/**
 * 微信内H5返回结果
 */
public class JsPayResult extends JsPayParams {
  private String errMsg;
  private String resultCode;

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }

  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }
}
