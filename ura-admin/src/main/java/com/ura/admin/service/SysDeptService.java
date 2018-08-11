package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysDeptEntity;

import java.util.List;
import java.util.Map;

/**
* 部门表
 * @author eamiear
 * @datetime 2018-08-11 19:34:31
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    List<SysDeptEntity> queryList(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params);

    List<Long> queryDeptIdList(Long parentId);

    List<Long> getSubDeptIdList(Long deptId);
}