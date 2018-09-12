package com.ura.api.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.api.dao.TbUserDao;
import com.ura.api.entity.TbUserEntity;
import com.ura.api.service.TbUserService;
import org.springframework.stereotype.Service;

@Service("tbUserService")
public class TbUserServiceImpl extends ServiceImpl<TbUserDao, TbUserEntity> implements TbUserService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TbUserEntity> page = this.selectPage(
                new Query<TbUserEntity>(params).getPage(),
                new EntityWrapper<TbUserEntity>());
        return new PageUtils(page);
    }
}