/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-09-26 18:05:21
 */

package com.ura.api.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 *  实体
 *  表名 app_version
*/

@TableName("app_version")
public class AppVersionEntity implements Serializable {
  @TableId
  private Long id;
  private String appname;
  private String versionNo;
  private String versionName;
  private String updateMsg;
  private Integer status;
  private Date publishTime;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId () {
    return id;
  }
  public void setAppname(String appname) {
    this.appname = appname;
  }

  public String getAppname () {
    return appname;
  }
  public void setVersionNo(String versionNo) {
    this.versionNo = versionNo;
  }

  public String getVersionNo () {
    return versionNo;
  }
  public void setVersionName(String versionName) {
    this.versionName = versionName;
  }

  public String getVersionName () {
    return versionName;
  }
  public void setUpdateMsg(String updateMsg) {
    this.updateMsg = updateMsg;
  }

  public String getUpdateMsg () {
    return updateMsg;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus () {
    return status;
  }

  public Date getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Date publishTime) {
    this.publishTime = publishTime;
  }
}