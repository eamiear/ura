/**
 * @author eamiear
 * @date 2018/9/17 14:29
 */

package com.ura.api.controller;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.common.utils.JSONResult;
import com.ura.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags = "公共接口")
public class ApiCommonController {

    @IgnoreAuth
    @GetMapping("c/version")
    @ApiOperation("获取APP版本号")
    public R version(){
        return R.success().put("data", JSONResult.build().put("v", "0.0.1"));
    }
}
