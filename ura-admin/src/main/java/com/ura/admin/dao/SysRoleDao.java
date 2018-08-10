package com.ura.admin.dao;

import com.ura.admin.entity.SysRoleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 角色表
 * @author eamiear
 * @datetime 2018-08-09 22:47:06
*/
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
  List<Long> queryRoleIdList(Long createUserId);
}