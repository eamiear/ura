package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractResult;

/**
 * JS-SDK 页面配置信息
 */
public class JsSDKConfig extends AbstractResult {
  private String appId;
  private long timestamp;
  private String noncestr;
  private String signature;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public String getNoncestr() {
    return noncestr;
  }

  public void setNoncestr(String noncestr) {
    this.noncestr = noncestr;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }
}
