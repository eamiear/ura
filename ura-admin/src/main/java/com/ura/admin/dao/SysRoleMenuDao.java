package com.ura.admin.dao;

import com.ura.admin.entity.SysRoleMenuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 角色菜单关联表
 * @author eamiear
 * @datetime 2018-08-11 19:34:31
*/
@Mapper
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenuEntity> {

  List<Long> queryMenuIdList(Long roleId);

  int deleteBatch(Long[] roleIds);
}