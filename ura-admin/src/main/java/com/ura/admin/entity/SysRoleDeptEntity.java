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
 *  角色部门表实体
 *  表名 sys_role_dept
*/

@TableName("sys_role_dept")
public class SysRoleDeptEntity implements Serializable {
  @TableId
  private Long roleId;
  private Long deptId;

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getRoleId () {
    return roleId;
  }
  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

  public Long getDeptId () {
    return deptId;
  }
}