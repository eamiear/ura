/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-08 23:00:51
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  用户表实体
 *  表名 sys_user
*/

@TableName("sys_user")
public class SysUserEntity implements Serializable {
  @TableId
  private Long userId;
  private String username;
  private String realname;
  private String password;
  private String email;
  private String avatar;
  private String introduction;
  private String mobile;
  private Integer sex;
  private String salt;
  private Integer status;
  private Integer locked;
  private Long deptId;
  private Date createTime;
  private Date updateTime;
  private Long createUserId;

  @TableField(exist = false)
  private List<Long> roleIdList;

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
  public void setRealname(String realname) {
    this.realname = realname;
  }

  public String getRealname () {
    return realname;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword () {
    return password;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail () {
    return email;
  }
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getAvatar () {
    return avatar;
  }
  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public String getIntroduction () {
    return introduction;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getMobile () {
    return mobile;
  }
  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Integer getSex () {
    return sex;
  }
  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getSalt () {
    return salt;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus () {
    return status;
  }
  public void setLocked(Integer locked) {
    this.locked = locked;
  }

  public Integer getLocked () {
    return locked;
  }
  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

  public Long getDeptId () {
    return deptId;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime () {
    return createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Long getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  public List<Long> getRoleIdList() {
    return roleIdList;
  }

  public void setRoleIdList(List<Long> roleIdList) {
    this.roleIdList = roleIdList;
  }
}