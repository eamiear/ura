/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-06 20:54:28
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 *  系统菜单实体
 *  表名 sys_menu
*/

@TableName("sys_menu")
public class SysMenuEntity implements Serializable {
  @TableId
  private Long menuId;
  private Long parentId;
  @TableField(exist = false)
  private String parentName;
  private String name;
  private String url;
  private String perms;
  private Integer type;
  private String icon;
  private Integer orders;
  private Integer status;
  private String createTime;
  private String updateTime;

  @TableField(exist = false)
  private Boolean isShow;
  @TableField(exist = false)
  private List<?> list;

  public void setMenuId(Long menuId) {
    this.menuId = menuId;
  }

  public Long getMenuId () {
    return menuId;
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

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getName () {
    return name;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  public String getUrl () {
    return url;
  }
  public void setPerms(String perms) {
    this.perms = perms;
  }

  public String getPerms () {
    return perms;
  }
  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getType () {
    return type;
  }
  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getIcon () {
    return icon;
  }
  public void setOrders(Integer orders) {
    this.orders = orders;
  }

  public Integer getOrders () {
    return orders;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus () {
    return status;
  }
  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getCreateTime () {
    return createTime;
  }
  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateTime () {
    return updateTime;
  }

  public Boolean getIsShow() {
    return isShow;
  }

  public void setIsShow(Boolean show) {
    this.isShow = show;
  }

  public List<?> getList() {
    return list;
  }

  public void setList(List<?> list) {
    this.list = list;
  }
}