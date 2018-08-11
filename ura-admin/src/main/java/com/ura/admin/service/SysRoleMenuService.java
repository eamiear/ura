package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysRoleMenuEntity;

import java.util.List;
import java.util.Map;

/**
* 角色菜单关联表
 * @author eamiear
 * @datetime 2018-08-11 19:34:31
 */
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {
    PageUtils queryPage(Map<String, Object> params);

    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    List<Long> queryMenuIdList(Long roleId);

    int deleteBatch(Long[] roleIds);
}