package com.ura.api.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.api.dao.TbTokenDao;
import com.ura.api.entity.TbTokenEntity;
import com.ura.api.service.TbTokenService;
import org.springframework.stereotype.Service;

@Service("tbTokenService")
public class TbTokenServiceImpl extends ServiceImpl<TbTokenDao, TbTokenEntity> implements TbTokenService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TbTokenEntity> page = this.selectPage(
                new Query<TbTokenEntity>(params).getPage(),
                new EntityWrapper<TbTokenEntity>());
        return new PageUtils(page);
    }
}