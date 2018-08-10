package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.MapUtils;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ura.admin.dao.SysUserRoleDao;
import com.ura.admin.entity.SysUserRoleEntity;
import com.ura.admin.service.SysUserRoleService;
import org.springframework.stereotype.Service;

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserRoleEntity> page = this.selectPage(new Query<SysUserRoleEntity>(params).getPage(), new EntityWrapper<SysUserRoleEntity>());
        return new PageUtils(page);
    }

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        this.deleteByMap(new MapUtils().put("user_id", userId));

        if (roleIdList == null || roleIdList.size() == 0) {
            return;
        }

        List<SysUserRoleEntity> list = new ArrayList<>(roleIdList.size());
        for (Long roleId : roleIdList) {
            SysUserRoleEntity userRoleEntity = new SysUserRoleEntity();
            userRoleEntity.setUserId(userId);
            userRoleEntity.setRoleId(roleId);

            list.add(userRoleEntity);
        }
        this.insertBatch(list);
    }

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return baseMapper.queryRoleIdList(userId);
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }
}