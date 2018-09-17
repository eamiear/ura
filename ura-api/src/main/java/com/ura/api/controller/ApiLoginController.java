package com.ura.api.controller;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.api.bean.LoginBean;
import com.ura.api.service.TokenService;
import com.ura.api.service.UserService;
import com.ura.common.utils.R;
import com.ura.common.validator.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(tags = "登录授权接口")
public class ApiLoginController {
  @Autowired
  private UserService userService;

  @Autowired
  private TokenService tokenService;

  @IgnoreAuth
  @PostMapping("login")
  @ApiOperation("登录")
  public R login(@ApiParam(value = "手机号") String mobile, @ApiParam(value = "密码") String password) {
    Assert.isBlank(mobile, "手机号码不能为空");
    Assert.isBlank(password, "密码不能为空");
    Map<String, Object> map = userService.login(mobile, password);
    return R.success().put("data", map);
  }

  @IgnoreAuth
  @PostMapping("logout")
  @ApiOperation("退出登录")
  public R logout(@ApiIgnore @RequestAttribute("userId") long userId) {
    tokenService.expireToken(userId);
    return R.success();
  }
}
