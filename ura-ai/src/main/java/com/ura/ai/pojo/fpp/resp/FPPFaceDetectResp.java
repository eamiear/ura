/**
 * @author eamiear
 * @date 2018/12/10 10:54
 */

package com.ura.ai.pojo.fpp.resp;

public class FPPFaceDetectResp {
  /**
   * 健康分数
   */
  private String health;
  /**
   * 色斑分数
   */
  private String stain;
  /**
   * 青春痘分数
   */
  private String acne;
  /**
   * 黑眼圈
   */
  private String darkCircle;

  public String getHealth() {
    return health;
  }

  public void setHealth(String health) {
    this.health = health;
  }

  public String getStain() {
    return stain;
  }

  public void setStain(String stain) {
    this.stain = stain;
  }

  public String getAcne() {
    return acne;
  }

  public void setAcne(String acne) {
    this.acne = acne;
  }

  public String getDarkCircle() {
    return darkCircle;
  }

  public void setDarkCircle(String darkCircle) {
    this.darkCircle = darkCircle;
  }
}
