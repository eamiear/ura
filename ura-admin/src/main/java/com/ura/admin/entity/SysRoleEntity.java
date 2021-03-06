/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-09 22:47:06
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  角色表实体
 *  表名 sys_role
*/

@TableName("sys_role")
public class SysRoleEntity implements Serializable {
  @TableId
  private Long roleId;
  @NotBlank(message = "角色名称不能为空")
  private String roleName;
  private String title;
  private String remark;
  private Integer orders;
  private Long createUserId;
  private Date createTime;

  @TableField(exist = false)
  private List<Long> menuIdList;

  @TableField(exist = false)
  private List<Long> deptIdList;

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

  public Long getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  public Integer getOrders () {
    return orders;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public List<Long> getMenuIdList() {
    return menuIdList;
  }

  public void setMenuIdList(List<Long> menuIdList) {
    this.menuIdList = menuIdList;
  }

  public List<Long> getDeptIdList() {
    return deptIdList;
  }

  public void setDeptIdList(List<Long> deptIdList) {
    this.deptIdList = deptIdList;
  }
}