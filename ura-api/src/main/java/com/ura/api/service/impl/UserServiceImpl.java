package com.ura.api.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.api.dao.UserDao;
import com.ura.api.entity.UserEntity;
import com.ura.api.service.UserService;
import org.springframework.stereotype.Service;

@Service("tbUserService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>());
        return new PageUtils(page);
    }
}