package com.ura.admin.controller;

import com.ura.admin.annotation.SysLog;
import com.ura.admin.entity.SysLogEntity;
import com.ura.admin.service.SysLogService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-12 16:02:57
*/
@RestController
@RequestMapping("sys/log")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @SysLog("查询日志列表")
    @RequestMapping("/list")
    @RequiresPermissions("sys:log:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysLogService.queryPage(params);
        return R.success().put("data", page);
    }
}
