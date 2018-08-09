package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.admin.dao.SysRoleDao;
import com.ura.admin.entity.SysRoleEntity;
import com.ura.admin.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleEntity> page = this.selectPage(new Query<SysRoleEntity>(params).getPage(), new EntityWrapper<SysRoleEntity>());
        return new PageUtils(page);
    }
}