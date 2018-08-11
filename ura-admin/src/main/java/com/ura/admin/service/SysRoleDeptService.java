package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysRoleDeptEntity;

import java.util.List;
import java.util.Map;

/**
* 角色部门表
 * @author eamiear
 * @datetime 2018-08-11 19:34:31
 */
public interface SysRoleDeptService extends IService<SysRoleDeptEntity> {
    PageUtils queryPage(Map<String, Object> params);

    void saveOrUpdate(Long roleId, List<Long> deptIdList);

    List<Long> queryDeptIdList(Long[] roleIds);

    int deleteBatch(Long[] roleIds);
}