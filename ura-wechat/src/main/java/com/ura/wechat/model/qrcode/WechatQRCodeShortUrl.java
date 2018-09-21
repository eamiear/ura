package com.ura.wechat.model.qrcode;

import com.ura.wechat.model.resp.ResultState;

/**
 * 二维码短链接返回结果
 */
public class WechatQRCodeShortUrl extends ResultState {
  // 短链接
  private String short_url;

  public String getShort_url() {
    return short_url;
  }

  public void setShort_url(String short_url) {
    this.short_url = short_url;
  }
}
