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
 *  表名 tb_user
*/

@TableName("tb_user")
public class TbUserEntity implements Serializable {
  @TableId
  private Long userId;
  private String username;
  private String password;
  private Integer gender;
  private String birthday;
  private String registerTime;
  private String lastLoginTime;
  private String registerIp;
  private String lastLgoinIp;
  private String nickname;
  private String mobile;
  private String avatar;
  private String weixinOpenid;
  private Integer groupId;
  private Integer locked;
  private Integer loginTimes;

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getUserId () {
    return userId;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername () {
    return username;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword () {
    return password;
  }
  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Integer getGender () {
    return gender;
  }
  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getBirthday () {
    return birthday;
  }
  public void setRegisterTime(String registerTime) {
    this.registerTime = registerTime;
  }

  public String getRegisterTime () {
    return registerTime;
  }
  public void setLastLoginTime(String lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String getLastLoginTime () {
    return lastLoginTime;
  }
  public void setRegisterIp(String registerIp) {
    this.registerIp = registerIp;
  }

  public String getRegisterIp () {
    return registerIp;
  }
  public void setLastLgoinIp(String lastLgoinIp) {
    this.lastLgoinIp = lastLgoinIp;
  }

  public String getLastLgoinIp () {
    return lastLgoinIp;
  }
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getNickname () {
    return nickname;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getMobile () {
    return mobile;
  }
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getAvatar () {
    return avatar;
  }
  public void setWeixinOpenid(String weixinOpenid) {
    this.weixinOpenid = weixinOpenid;
  }

  public String getWeixinOpenid () {
    return weixinOpenid;
  }
  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public Integer getGroupId () {
    return groupId;
  }
  public void setLocked(Integer locked) {
    this.locked = locked;
  }

  public Integer getLocked () {
    return locked;
  }
  public void setLoginTimes(Integer loginTimes) {
    this.loginTimes = loginTimes;
  }

  public Integer getLoginTimes () {
    return loginTimes;
  }
}