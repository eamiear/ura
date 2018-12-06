/**
 * @author eamiear
 * @date 2018/12/3 16:23
 */

package com.ura.ai.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("ai_bd_general")
public class GeneralDetectEntity {
  @TableId
  private Long id;
  private String logId;
  private Integer resultNum;
  private String name;
  private String score;
  private String year;
  private String colorResult;
  private Integer localWidth;
  private Integer localHeight;
  private Integer localTop;
  private Integer localLeft;
  private String logoType;
  private String probability;
  private String imagePath;
  private String openId;
  private String nickname;
  private String enterType;
  private String detectType;
  private String baikeUrl;
  private String baikeImageUrl;
  private String baikeDescription;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogId() {
    return logId;
  }

  public void setLogId(String logId) {
    this.logId = logId;
  }

  public Integer getResultNum() {
    return resultNum;
  }

  public void setResultNum(Integer resultNum) {
    this.resultNum = resultNum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getColorResult() {
    return colorResult;
  }

  public void setColorResult(String colorResult) {
    this.colorResult = colorResult;
  }

  public Integer getLocalWidth() {
    return localWidth;
  }

  public void setLocalWidth(Integer localWidth) {
    this.localWidth = localWidth;
  }

  public Integer getLocalHeight() {
    return localHeight;
  }

  public void setLocalHeight(Integer localHeight) {
    this.localHeight = localHeight;
  }

  public Integer getLocalTop() {
    return localTop;
  }

  public void setLocalTop(Integer localTop) {
    this.localTop = localTop;
  }

  public Integer getLocalLeft() {
    return localLeft;
  }

  public void setLocalLeft(Integer localLeft) {
    this.localLeft = localLeft;
  }

  public String getLogoType() {
    return logoType;
  }

  public void setLogoType(String logoType) {
    this.logoType = logoType;
  }

  public String getProbability() {
    return probability;
  }

  public void setProbability(String probability) {
    this.probability = probability;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEnterType() {
    return enterType;
  }

  public void setEnterType(String enterType) {
    this.enterType = enterType;
  }

  public String getDetectType() {
    return detectType;
  }

  public void setDetectType(String detectType) {
    this.detectType = detectType;
  }

  public String getBaikeUrl() {
    return baikeUrl;
  }

  public void setBaikeUrl(String baikeUrl) {
    this.baikeUrl = baikeUrl;
  }

  public String getBaikeImageUrl() {
    return baikeImageUrl;
  }

  public void setBaikeImageUrl(String baikeImageUrl) {
    this.baikeImageUrl = baikeImageUrl;
  }

  public String getBaikeDescription() {
    return baikeDescription;
  }

  public void setBaikeDescription(String baikeDescription) {
    this.baikeDescription = baikeDescription;
  }
}
