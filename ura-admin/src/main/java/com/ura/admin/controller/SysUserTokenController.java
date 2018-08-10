package com.ura.admin.controller;

import com.ura.admin.entity.SysUserTokenEntity;
import com.ura.admin.service.SysUserTokenService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-10 17:03:53
*/
@RestController
@RequestMapping("sysusertoken")
public class SysUserTokenController {
    @Autowired
    private SysUserTokenService sysUserTokenService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysUserTokenService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId) {
        SysUserTokenEntity sysUserToken = sysUserTokenService.selectById(userId);
        return R.success().put("data", sysUserToken);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysUserTokenEntity sysUserToken) {
        sysUserTokenService.insert(sysUserToken);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysUserTokenEntity sysUserToken) {
        ValidatorUtils.validateEntity(sysUserToken);
        sysUserTokenService.updateAllColumnById(sysUserToken);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] userIds) {
        sysUserTokenService.deleteBatchIds(Arrays.asList(userIds));
        return R.success();
    }
}
