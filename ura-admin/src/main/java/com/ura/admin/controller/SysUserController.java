package com.ura.admin.controller;

import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.service.SysUserService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 用户表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-08 23:00:51
*/
@RestController
@RequestMapping("sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysUserService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId) {
        SysUserEntity sysUser = sysUserService.selectById(userId);
        return R.success().put("data", sysUser);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysUserEntity sysUser) {
        sysUserService.insert(sysUser);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysUserEntity sysUser) {
        ValidatorUtils.validateEntity(sysUser);
        sysUserService.updateAllColumnById(sysUser);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] userIds) {
        sysUserService.deleteBatchIds(Arrays.asList(userIds));
        return R.success();
    }
}
