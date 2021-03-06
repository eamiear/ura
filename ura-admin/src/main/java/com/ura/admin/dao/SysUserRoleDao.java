package com.ura.admin.dao;

import com.ura.admin.entity.SysUserRoleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 
 * @author eamiear
 * @datetime 2018-08-09 22:47:05
*/
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {

  List<Long> queryRoleIdList(Long userId);

  int deleteBatch(Long[] roleIds);
}