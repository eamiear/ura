/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-09 22:47:06
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 *  角色表实体
 *  表名 sys_role
*/

@TableName("sys_role")
public class SysRoleEntity implements Serializable {
  @TableId
  private Long roleId;
  private String roleName;
  private String title;
  private String remark;
  private Integer orders;

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getRoleId () {
    return roleId;
  }
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleName () {
    return roleName;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle () {
    return title;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getRemark () {
    return remark;
  }
  public void setOrders(Integer orders) {
    this.orders = orders;
  }

  public Integer getOrders () {
    return orders;
  }
}