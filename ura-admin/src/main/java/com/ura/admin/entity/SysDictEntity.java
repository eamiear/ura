/**
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-12 16:02:57
 */

package com.ura.admin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 *  数据字典表实体
 *  表名 sys_dict
*/

@TableName("sys_dict")
public class SysDictEntity implements Serializable {
  @TableId
  private Long id;
  @NotBlank(message = "字典名称不能为空")
  private String name;
  @NotBlank(message = "字典类型不能为空")
  private String type;
  @NotBlank(message = "字典码不能为空")
  private String code;
  @NotBlank(message = "字典值不能为空")
  private String value;
  private Integer order;
  private String remark;
  @TableLogic
  private Integer del;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId () {
    return id;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getName () {
    return name;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getType () {
    return type;
  }
  public void setCode(String code) {
    this.code = code;
  }

  public String getCode () {
    return code;
  }
  public void setValue(String value) {
    this.value = value;
  }

  public String getValue () {
    return value;
  }
  public void setOrder(Integer order) {
    this.order = order;
  }

  public Integer getOrder () {
    return order;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getRemark () {
    return remark;
  }
  public void setDel(Integer del) {
    this.del = del;
  }

  public Integer getDel () {
    return del;
  }
}