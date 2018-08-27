package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.admin.dao.SysConfigDao;
import com.ura.admin.entity.SysConfigEntity;
import com.ura.admin.service.SysConfigService;
import org.springframework.stereotype.Service;

@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfigEntity> implements SysConfigService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysConfigEntity> page = this.selectPage(
                new Query<SysConfigEntity>(params).getPage(),
                new EntityWrapper<SysConfigEntity>());
        return new PageUtils(page);
    }
}