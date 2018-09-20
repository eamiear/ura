package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractParams;

import java.util.Map;
import java.util.TreeMap;

public class AuthTokenParams extends AbstractParams {
  private String appid; // 公众号唯一标识
  private String secret; // 公众号app secret
  private String code;  // 填写code参数
  private String grant_type = "authorization_code";

  public AuthTokenParams(){
    super();
  }

  public AuthTokenParams(String appid, String secret, String code, String grant_type){
    super();
    this.appid = appid;
    this.secret = secret;
    this.code = code;
    this.grant_type = grant_type;
  }

  @Override
  public Map<String, String> getParams() {
    Map<String, String> params = new TreeMap<String, String>();
    params.put("appid", this.appid);
    params.put("secret", this.secret);
    params.put("code", this.code);
    params.put("grant_type", this.grant_type);
    return params;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getGrant_type() {
    return grant_type;
  }

  public void setGrant_type(String grant_type) {
    this.grant_type = grant_type;
  }
}
