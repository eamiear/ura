package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysUserRoleEntity;

import java.util.List;
import java.util.Map;

/**
* 
 * @author eamiear
 * @datetime 2018-08-09 22:47:05
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {
    PageUtils queryPage(Map<String, Object> params);

    void saveOrUpdate(Long userId, List<Long> roleIdList);

    List<Long> queryRoleIdList(Long userId);

    int deleteBatch(Long[] roleIds);
}