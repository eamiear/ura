/**
 * @author eamiear
 * @date 2018/9/17 14:29
 */

package com.ura.api.controller;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.api.entity.AppVersionEntity;
import com.ura.api.service.AppVersionService;
import com.ura.common.utils.JSONResult;
import com.ura.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags = "公共接口")
public class ApiCommonController {

    @Autowired
    private AppVersionService appVersionService;

    @IgnoreAuth
    @GetMapping("c/version")
    @ApiOperation("获取APP版本号")
    public R version(){
        AppVersionEntity version = appVersionService.queryLatestVersion();
        JSONResult result = JSONResult.build();
        R r = new R();

        if (version != null){
            String versionName = version.getVersionName();
            String versionMsg = version.getUpdateMsg();
            r.put("data", result.put("v", version.getVersionNo())
                    .put("version", version.getVersionNo())
                    .put("name", versionName != null ? versionName : "")
                    .put("description", versionMsg != null ? versionMsg : ""));
        } else {
            r.put("data", "").put("msg", "没有记录");
        }
        return r;
    }
}
