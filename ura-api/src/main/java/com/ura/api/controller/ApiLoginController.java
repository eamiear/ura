package com.ura.api.controller;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.api.bean.LoginBean;
import com.ura.api.service.TokenService;
import com.ura.api.service.UserService;
import com.ura.common.utils.R;
import com.ura.common.validator.Assert;
import com.ura.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(tags = "Api登录授权接口")
public class ApiLoginController {
  @Autowired
  private UserService userService;

  @Autowired
  private TokenService tokenService;

  @PostMapping("login")
  @ApiOperation("登录")
  public R login(@RequestBody LoginBean loginBean) {
    ValidatorUtils.validateEntity(loginBean);

    Map<String, Object> map = userService.login(loginBean);
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
