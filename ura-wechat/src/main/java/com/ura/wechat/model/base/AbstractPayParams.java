package com.ura.wechat.model.base;

import java.io.Serializable;

public abstract class AbstractPayParams implements Serializable{
  private String appid; // 公众号id
  private String mch_id; // 商户id
  private String nonce_str; //随机字符串
  private String sign;  // 签名
  private String sign_type; // 签名类型

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getMch_id() {
    return mch_id;
  }

  public void setMch_id(String mch_id) {
    this.mch_id = mch_id;
  }

  public String getNonce_str() {
    return nonce_str;
  }

  public void setNonce_str(String nonce_str) {
    this.nonce_str = nonce_str;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getSign_type() {
    return sign_type;
  }

  public void setSign_type(String sign_type) {
    this.sign_type = sign_type;
  }
}
