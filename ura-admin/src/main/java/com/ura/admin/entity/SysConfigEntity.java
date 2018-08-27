/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-27 13:43:12
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 *  系统配置实体
 *  表名 sys_config
*/

@TableName("sys_config")
public class SysConfigEntity implements Serializable {
  @TableId
  private Integer id;
  @NotBlank(message = "参数名不能为空")
  private String key;
  @NotBlank(message = "参数值不能为空")
  private String value;
  private Integer status;
  private String remark;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId () {
    return id;
  }
  public void setKey(String key) {
    this.key = key;
  }

  public String getKey () {
    return key;
  }
  public void setValue(String value) {
    this.value = value;
  }

  public String getValue () {
    return value;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus () {
    return status;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getRemark () {
    return remark;
  }
}