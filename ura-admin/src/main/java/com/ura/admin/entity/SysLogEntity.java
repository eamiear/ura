/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-12 16:02:57
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 *  实体
 *  表名 sys_log
*/

@TableName("sys_log")
public class SysLogEntity implements Serializable {
  @TableId
  private Long id;
  private String username;
  private String operation;
  private String method;
  private String params;
  private String time;
  private String ip;
  private Date createTime;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId () {
    return id;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername () {
    return username;
  }
  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getOperation () {
    return operation;
  }
  public void setMethod(String method) {
    this.method = method;
  }

  public String getMethod () {
    return method;
  }
  public void setParams(String params) {
    this.params = params;
  }

  public String getParams () {
    return params;
  }
  public void setTime(String time) {
    this.time = time;
  }

  public String getTime () {
    return time;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getIp () {
    return ip;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime () {
    return createTime;
  }
}