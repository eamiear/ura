package com.ura.admin.controller;

import com.ura.admin.entity.SysConfigEntity;
import com.ura.admin.service.SysConfigService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 系统配置
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-27 13:43:12
*/
@RestController
@RequestMapping("sys/config")
public class SysConfigController {
    @Autowired
    private SysConfigService sysConfigService;

    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysConfigService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public R info(@PathVariable("id") Integer id) {
        SysConfigEntity sysConfig = sysConfigService.selectById(id);
        return R.success().put("data", sysConfig);
    }

    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public R save (@RequestBody SysConfigEntity sysConfig) {
        ValidatorUtils.validateEntity(sysConfig);
        sysConfigService.insert(sysConfig);
        return R.success();
    }

    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public R update ( @RequestBody SysConfigEntity sysConfig) {
        ValidatorUtils.validateEntity(sysConfig);
        sysConfigService.updateAllColumnById(sysConfig);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Integer[] ids) {
        sysConfigService.deleteBatchIds(Arrays.asList(ids));
        return R.success();
    }
}
