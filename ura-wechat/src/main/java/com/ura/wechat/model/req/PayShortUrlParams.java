package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractPayParams;

/**
 * 二维码链接转换成短链接请求参数
 */
public class PayShortUrlParams extends AbstractPayParams {
  private String long_url;

  public String getLong_url() {
    return long_url;
  }

  public void setLong_url(String long_url) {
    this.long_url = long_url;
  }
}
