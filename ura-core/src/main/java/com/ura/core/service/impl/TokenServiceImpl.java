package com.ura.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.core.dao.TokenDao;
import com.ura.core.entity.TokenEntity;
import com.ura.core.service.TokenService;
import com.ura.common.utils.CustomTokenUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

    // 12小时后过期
    private final static int EXPIRE = 1000 * 60 * 60 * 12;

    @Override
    public TokenEntity queryByToken(String token) {
        return this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
    }

    @Override
    public TokenEntity createToken(long userId) {
      Date now = new Date();
      Date expireTime = new Date(now.getTime() + EXPIRE);
      String token = CustomTokenUtils.generateToken();

      TokenEntity tokenEntity = new TokenEntity();
      tokenEntity.setUserId(userId);
      tokenEntity.setToken(token);
      tokenEntity.setUpdateTime(now);
      tokenEntity.setExpireTime(expireTime);
      this.insertOrUpdate(tokenEntity);

      return tokenEntity;
    }

    @Override
    public void expireToken(long userId) {
      Date now = new Date();

      TokenEntity tokenEntity = new TokenEntity();
      tokenEntity.setUserId(userId);
      tokenEntity.setUpdateTime(now);
      tokenEntity.setExpireTime(now);
      this.insertOrUpdate(tokenEntity);
    }
}