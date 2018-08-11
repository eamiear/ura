package com.ura.admin.dao;

import com.ura.admin.entity.SysRoleDeptEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 角色部门表
 * @author eamiear
 * @datetime 2018-08-11 19:34:31
*/
@Mapper
public interface SysRoleDeptDao extends BaseMapper<SysRoleDeptEntity> {
  List<Long> queryDeptIdList(Long[] roleIds);

  int deleteBatch(Long[] roleIds);
}