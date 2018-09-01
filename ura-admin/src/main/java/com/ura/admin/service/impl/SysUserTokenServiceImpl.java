package com.ura.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.*;

import java.util.Date;
import java.util.Map;

import com.ura.admin.dao.SysUserTokenDao;
import com.ura.admin.entity.SysUserTokenEntity;
import com.ura.admin.service.SysUserTokenService;
import org.springframework.stereotype.Service;

@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserTokenEntity> page = this.selectPage(new Query<SysUserTokenEntity>(params).getPage(), new EntityWrapper<SysUserTokenEntity>());
        return new PageUtils(page);
    }

    @Override
    public R createToken(Long userId) {
        String token = CustomTokenUtils.generateToken();

        Date date = new Date();

        Date expireTime = new Date(date.getTime() + Constant.CUSTOME_TOKEN_EXPIRATION_TIME);

        SysUserTokenEntity tokenEntity = this.selectById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(date);
            tokenEntity.setExpireTime(expireTime);

            this.insert(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(date);
            tokenEntity.setExpireTime(expireTime);
            this.updateById(tokenEntity);
        }
        JSONObject tokenObj = new JSONObject();
        tokenObj.put("token", token);
        tokenObj.put("expire", Constant.CUSTOME_TOKEN_EXPIRATION_TIME);
        tokenObj.put("uid", userId);
        return R.success().put("data", tokenObj);
    }

    @Override
    public void updateToken(Long userId) {
        String token = CustomTokenUtils.generateToken();

        SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }
}