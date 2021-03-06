package com.ura.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.core.entity.TokenEntity;

/**
* 
 * @author eamiear
 * @datetime 2018-09-12 17:46:35
 */
public interface TokenService extends IService<TokenEntity> {
    TokenEntity queryByToken(String token);

    TokenEntity createToken(long userId);

    void expireToken(long userId);
}