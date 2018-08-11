/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-11 19:34:31
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 *  角色菜单关联表实体
 *  表名 sys_role_menu
*/

@TableName("sys_role_menu")
public class SysRoleMenuEntity implements Serializable {
  @TableId
  private Long roleId;
  private Long menuId;

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getRoleId () {
    return roleId;
  }
  public void setMenuId(Long menuId) {
    this.menuId = menuId;
  }

  public Long getMenuId () {
    return menuId;
  }
}