package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.Constant;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ura.admin.dao.SysMenuDao;
import com.ura.admin.entity.SysMenuEntity;
import com.ura.admin.service.SysMenuService;
import org.springframework.stereotype.Service;

@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysMenuEntity> page = this.selectPage(new Query<SysMenuEntity>(params).getPage(), new EntityWrapper<SysMenuEntity>());
        return new PageUtils(page);
    }

    @Override
    public List<SysMenuEntity> queryListByParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenuEntity> menuList = queryListByParentId(parentId);
        if (menuIdList == null) {
            return menuList;
        }
        List<SysMenuEntity> userMenuList = new ArrayList<>();
        for (SysMenuEntity menu : menuList) {
            if (menuIdList.contains(menu.getMenuId())) {
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<SysMenuEntity> queryListByParentId(Long parentId) {
        return baseMapper.queryListByParentId(parentId);
    }

    @Override
    public List<SysMenuEntity> queryListNotButtonList() {
        return baseMapper.queryNotButtonList();
    }

    @Override
    public List<SysMenuEntity> getUserMenuList() {
//        if (userId == Constant.SUPER_ADMIN) {
//            return getAllMenuList(null);
//        }
        return getAllMenuList(null);
    }

    @Override
    public void delete(Long menuId) {
        this.deleteById(menuId);
    }

    private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList) {
        List<SysMenuEntity> menuList = queryListByParentId(0L, menuIdList);
        getMenuTreeList(menuList, menuIdList);
        return menuList;
    }

    private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList){
        List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();

        for (SysMenuEntity entity : menuList) {
            if (entity.getType() == Constant.MenuType.CATALOG.getValue()) {
                entity.setList(getMenuTreeList(queryListByParentId(entity.getMenuId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }
        return subMenuList;
    }
}