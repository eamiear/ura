package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.admin.dao.SysUserDao;
import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.service.SysUserService;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserEntity> page = this.selectPage(new Query<SysUserEntity>(params).getPage(), new EntityWrapper<SysUserEntity>());
        return new PageUtils(page);
    }
}