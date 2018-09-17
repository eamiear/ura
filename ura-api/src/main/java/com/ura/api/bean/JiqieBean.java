/**
 * @author eamiear
 * @date 2018/9/13 15:36
 */

package com.ura.api.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JiqieBean {
  @Value(value = "${ura.art-third-url.yishuzi.url}")
  private String url;
  @Value(value = "${ura.art-third-url.yishuzi.domain}")
  private String domain;
  @Value(value = "${ura.art-third-url.yishuzi.idi}")
  private String host;
  @Value(value = "${ura.art-third-url.yishuzi.id1}")
  private String fontFamily;
  @Value(value = "${ura.art-third-url.yishuzi.id2}")
  private String background;
  @Value(value = "${ura.art-third-url.yishuzi.id4}")
  private String decorator;
  @Value(value = "${ura.art-third-url.yishuzi.id6}")
  private String color;
  @Value(value = "${ura.art-third-url.yishuzi.rect.x}")
  private String rectX;
  @Value(value = "${ura.art-third-url.yishuzi.rect.y}")
  private String rectY;
  @Value(value = "${ura.art-third-url.yishuzi.rect.width}")
  private String rectWidth;
  @Value(value = "${ura.art-third-url.yishuzi.rect.height}")
  private String rectHeight;

  private String suffix;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getFontFamily() {
    return fontFamily;
  }

  public void setFontFamily(String fontFamily) {
    this.fontFamily = fontFamily;
  }

  public String getBackground() {
    return background;
  }

  public void setBackground(String background) {
    this.background = background;
  }

  public String getDecorator() {
    return decorator;
  }

  public void setDecorator(String decorator) {
    this.decorator = decorator;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRectX() {
    return rectX;
  }

  public void setRectX(String rectX) {
    this.rectX = rectX;
  }

  public String getRectY() {
    return rectY;
  }

  public void setRectY(String rectY) {
    this.rectY = rectY;
  }

  public String getRectWidth() {
    return rectWidth;
  }

  public void setRectWidth(String rectWidth) {
    this.rectWidth = rectWidth;
  }

  public String getRectHeight() {
    return rectHeight;
  }

  public void setRectHeight(String rectHeight) {
    this.rectHeight = rectHeight;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
}
