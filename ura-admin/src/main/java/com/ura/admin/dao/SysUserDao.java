package com.ura.admin.dao;

import com.ura.admin.entity.SysUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 用户表
 * @author eamiear
 * @datetime 2018-08-08 23:00:51
*/
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
  List<String> queryAllPermissionsByUserId(Long userId);

  List<Long> queryAllMenuIdByUserId(Long userId);

  SysUserEntity queryByUserName(String userName);
}