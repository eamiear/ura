package com.ura.admin.dao;

import com.ura.admin.entity.SysUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
* 用户表
 * @author eamiear
 * @datetime 2018-08-08 23:00:51
*/
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

}