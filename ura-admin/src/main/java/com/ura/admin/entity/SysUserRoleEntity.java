/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-09 22:47:05
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 *  实体
 *  表名 sys_user_role
*/

@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {
  @TableId
  private Long id;
  private Long userId;
  private Long roleId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getUserId () {
    return userId;
  }
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getRoleId () {
    return roleId;
  }
}