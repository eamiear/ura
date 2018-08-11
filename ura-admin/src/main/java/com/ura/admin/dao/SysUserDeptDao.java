package com.ura.admin.dao;

import com.ura.admin.entity.SysUserDeptEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 用户部门关联表
 * @author eamiear
 * @datetime 2018-08-11 19:34:31
*/
@Mapper
public interface SysUserDeptDao extends BaseMapper<SysUserDeptEntity> {

}