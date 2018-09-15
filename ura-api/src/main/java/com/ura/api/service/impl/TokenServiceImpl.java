package com.ura.api.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


import com.ura.api.dao.TokenDao;
import com.ura.api.entity.TokenEntity;
import com.ura.api.service.TokenService;
import org.springframework.stereotype.Service;

@Service("tbTokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

    // 12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    public TokenEntity queryByToken(String token) {
        return this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
    }

    @Override
    public TokenEntity createToken(long userId) {
        return null;
    }

    @Override
    public void expireToken(long userId) {

    }
}