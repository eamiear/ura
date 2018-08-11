package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ura.admin.dao.SysRoleMenuDao;
import com.ura.admin.entity.SysRoleMenuEntity;
import com.ura.admin.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleMenuEntity> page = this.selectPage(new Query<SysRoleMenuEntity>(params).getPage(), new EntityWrapper<SysRoleMenuEntity>());
        return new PageUtils(page);
    }

    @Override
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        this.deleteById(roleId);

        if (menuIdList == null || menuIdList.size() == 0) {
            return;
        }

        List<SysRoleMenuEntity> list = new ArrayList<>();
        for (Long menuId : menuIdList) {
            SysRoleMenuEntity roleMenuEntity = new SysRoleMenuEntity();
            roleMenuEntity.setRoleId(roleId);
            roleMenuEntity.setMenuId(menuId);
            list.add(roleMenuEntity);
        }

        this.insertBatch(list);
    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return baseMapper.queryMenuIdList(roleId);
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }
}