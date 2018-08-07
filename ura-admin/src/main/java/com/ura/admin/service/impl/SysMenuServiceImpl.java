package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

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
}