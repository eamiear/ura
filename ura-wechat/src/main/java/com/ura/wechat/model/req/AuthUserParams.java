package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractParams;

import java.util.Map;
import java.util.TreeMap;

/**
 * 获取用户信息请求
 */
public class AuthUserParams extends AbstractParams {
  private String accessToken;
  private String openid;
  private String lang;

  @Override
  public Map<String, String> getParams() {
    Map<String, String> params = new TreeMap<>();
    params.put("access_token", this.accessToken);
    params.put("openid", this.openid);
    params.put("lang", this.lang);
    return params;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }
}
