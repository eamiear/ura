package com.ura.wechat.model.req;

import java.io.Serializable;

/**
 * 扫码模式——回调商户支付URL请求参数
 */
public class PayCallBackParams implements Serializable {
  private String appid; // 公众号id
  private String openid; // 用户标识
  private String mch_id;  // 商户号
  private String is_subscribe;  // 用户是否关注公众号，仅在公众账号类型支付有效，取值范围，Y或N; Y - 关注； N - 未关注
  private String nonce_str; //随机字符，不长于32位
  private String product_id;  // 商户定义的商品id 或订单号
  private String sign;  // 签名

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getMch_id() {
    return mch_id;
  }

  public void setMch_id(String mch_id) {
    this.mch_id = mch_id;
  }

  public String getIs_subscribe() {
    return is_subscribe;
  }

  public void setIs_subscribe(String is_subscribe) {
    this.is_subscribe = is_subscribe;
  }

  public String getNonce_str() {
    return nonce_str;
  }

  public void setNonce_str(String nonce_str) {
    this.nonce_str = nonce_str;
  }

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }
}
