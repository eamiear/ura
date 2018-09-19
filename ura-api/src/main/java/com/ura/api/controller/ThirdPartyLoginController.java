/**
 * @author eamiear
 * @date 2018/9/19 17:11
 */

package com.ura.api.controller;

import com.ura.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Api(tags = "第三方登录接口")
public class ThirdPartyLoginController {

    @GetMapping("/callback/wx")
    @ApiOperation(value = "微信登录回调")
    public R wxCallback(String code, HttpServletRequest request){

    }
}
