/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-09-12 17:46:35
 */

package com.ura.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 *  实体
 *  表名 tb_token
*/

@TableName("tb_token")
public class TokenEntity implements Serializable {
  @TableId(type= IdType.INPUT)
  private Long userId;
  private String token;
  private Date expireTime;
  private Date updateTime;

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
  public void setExpireTime(Date expireTime) {
    this.expireTime = expireTime;
  }

  public Date getExpireTime () {
    return expireTime;
  }
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getUpdateTime () {
    return updateTime;
  }
}