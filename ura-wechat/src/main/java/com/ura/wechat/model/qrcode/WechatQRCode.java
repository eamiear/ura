package com.ura.wechat.model.qrcode;

/**
 * 微信带参二维码
 */
public class WechatQRCode {
  // 获取的二维码
  private String ticket;
  // 二维码的有效时间，单位 秒，最大不超过2592000（30天）
  private int expire_seconds;
  // 二维码图片解析后的地址
  private String url;

  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public int getExpire_seconds() {
    return expire_seconds;
  }

  public void setExpire_seconds(int expire_seconds) {
    this.expire_seconds = expire_seconds;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
