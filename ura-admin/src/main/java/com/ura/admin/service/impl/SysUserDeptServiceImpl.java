package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.admin.dao.SysUserDeptDao;
import com.ura.admin.entity.SysUserDeptEntity;
import com.ura.admin.service.SysUserDeptService;
import org.springframework.stereotype.Service;

@Service("sysUserDeptService")
public class SysUserDeptServiceImpl extends ServiceImpl<SysUserDeptDao, SysUserDeptEntity> implements SysUserDeptService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserDeptEntity> page = this.selectPage(new Query<SysUserDeptEntity>(params).getPage(), new EntityWrapper<SysUserDeptEntity>());
        return new PageUtils(page);
    }
}