package com.ura.api.controller;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.api.entity.UserEntity;
import com.ura.api.service.UserService;
import com.ura.common.utils.R;
import com.ura.common.validator.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
@Api(tags = "注册接口")
public class ApiRegisterController {
  @Autowired
  private UserService userService;


  @IgnoreAuth
  @PostMapping("register")
  @ApiOperation("注册")
  public R register(@ApiParam(value = "手机号") String mobile, @ApiParam(value = "密码") String password){
    Assert.isBlank(mobile, "手机号码不能为空");
    Assert.isBlank(password, "密码不能为空");

    UserEntity userEntity = new UserEntity();
    userEntity.setMobile(mobile);
    userEntity.setUsername(mobile);
    userEntity.setPassword(DigestUtils.sha256Hex(password));
    userEntity.setRegisterTime(new Date());
    userService.insert(userEntity);
    return R.success("注册成功");
  }
}
