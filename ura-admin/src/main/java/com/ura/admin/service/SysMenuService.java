package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
* 系统菜单
 * @author eamiear
 * @datetime 2018-08-06 20:54:28
 */
public interface SysMenuService extends IService<SysMenuEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<SysMenuEntity> queryListByParentId(Long parentId, List<Long> menuIdList);

    List<SysMenuEntity> queryListByParentId(Long parentId);

    List<SysMenuEntity> queryListNotButtonList();

    List<SysMenuEntity> getUserMenuList();

    void delete(Long menuId);
}