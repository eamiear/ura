package com.ura.api.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.api.bean.LoginBean;

import java.util.HashMap;
import java.util.Map;

import com.ura.api.dao.UserDao;
import com.ura.api.entity.TokenEntity;
import com.ura.api.entity.UserEntity;
import com.ura.api.service.TokenService;
import com.ura.api.service.UserService;
import com.ura.common.exception.URAException;
import com.ura.common.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
  @Autowired
  private TokenService tokenService;

  @Override
  public UserEntity queryByMobile(String mobile) {
    UserEntity user = new UserEntity();
    user.setMobile(mobile);
    return baseMapper.selectOne(user);
  }

  @Override
  public UserEntity queryByOpenId(String openId) {
    return this.selectOne(new EntityWrapper<UserEntity>().eq("weixin_openid", openId));
  }

  @Override
  public Map<String, Object> login(String mobile, String password) {
    UserEntity user = queryByMobile(mobile);
    Assert.isNull(user, "手机号或密码错误");

    if (!user.getPassword().equals(DigestUtils.sha256Hex(password))){
      throw new URAException("手机号或密码错误");
    }
    TokenEntity token = tokenService.createToken(user.getUserId());
    Map<String, Object> map = new HashMap<>(2);
    map.put("token", token.getToken());
    map.put("expire", token.getExpireTime().getTime() - System.currentTimeMillis());
    return map;
  }
}