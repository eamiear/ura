package com.ura.api.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
@ConfigurationProperties(prefix = "ura.third-login")
public class WechatBean {

  @NotEmpty
  private String wechatAppId;
  @NotEmpty
  private String wechatAppSecret;
  @NotEmpty
  private String wechatRedirectUrl;

  public String getWechatAppId() {
    return wechatAppId;
  }

  public void setWechatAppId(String wechatAppId) {
    this.wechatAppId = wechatAppId;
  }

  public String getWechatAppSecret() {
    return wechatAppSecret;
  }

  public void setWechatAppSecret(String wechatAppSecret) {
    this.wechatAppSecret = wechatAppSecret;
  }

  public String getWechatRedirectUrl() {
    return wechatRedirectUrl;
  }

  public void setWechatRedirectUrl(String wechatRedirectUrl) {
    this.wechatRedirectUrl = wechatRedirectUrl;
  }
}
