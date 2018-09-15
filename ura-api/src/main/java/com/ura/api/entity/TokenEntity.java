/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-09-12 17:46:35
 */

package com.ura.api.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 *  实体
 *  表名 tb_token
*/

@TableName("tb_token")
public class TokenEntity implements Serializable {
  @TableId
  private Long userId;
  private String token;
  private String expireTime;
  private String updateTime;

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getUserId () {
    return userId;
  }
  public void setToken(String token) {
    this.token = token;
  }

  public String getToken () {
    return token;
  }
  public void setExpireTime(String expireTime) {
    this.expireTime = expireTime;
  }

  public String getExpireTime () {
    return expireTime;
  }
  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateTime () {
    return updateTime;
  }
}