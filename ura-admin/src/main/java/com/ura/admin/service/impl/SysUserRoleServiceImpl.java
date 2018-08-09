package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

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
}