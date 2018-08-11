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
 *  用户部门关联表实体
 *  表名 sys_user_dept
*/

@TableName("sys_user_dept")
public class SysUserDeptEntity implements Serializable {
  @TableId
  private Long userId;
  private Long deptId;

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getUserId () {
    return userId;
  }
  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

  public Long getDeptId () {
    return deptId;
  }
}