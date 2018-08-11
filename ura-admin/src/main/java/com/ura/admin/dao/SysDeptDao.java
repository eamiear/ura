package com.ura.admin.dao;

import com.ura.admin.entity.SysDeptEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 部门表
 * @author eamiear
 * @datetime 2018-08-11 19:34:31
*/
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {

  List<Long> queryDeptIdList(Long parentId);
}