/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-11 19:34:31
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 *  部门表实体
 *  表名 sys_dept
*/

@TableName("sys_dept")
public class SysDeptEntity implements Serializable {
  @TableId
  private Long deptId;
  private Long parentId;
  private String name;

  @TableField(exist=false)
  private String parentName;
  private Integer orders;
  private Integer delFlag;

  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

  public Long getDeptId () {
    return deptId;
  }
  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Long getParentId () {
    return parentId;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getName () {
    return name;
  }
  public void setOrders(Integer orders) {
    this.orders = orders;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public Integer getOrders () {
    return orders;
  }
  public void setDelFlag(Integer delFlag) {
    this.delFlag = delFlag;
  }

  public Integer getDelFlag () {
    return delFlag;
  }
}