package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.admin.dao.SysDictDao;
import com.ura.admin.entity.SysDictEntity;
import com.ura.admin.service.SysDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");
        Page<SysDictEntity> page = this.selectPage(
                new Query<SysDictEntity>(params).getPage(),
                new EntityWrapper<SysDictEntity>()
                        .like(StringUtils.isNotBlank(name), "name", name));
        return new PageUtils(page);
    }
}