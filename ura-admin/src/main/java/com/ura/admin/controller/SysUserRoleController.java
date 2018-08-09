package com.ura.admin.controller;

import com.ura.admin.entity.SysUserRoleEntity;
import com.ura.admin.service.SysUserRoleService;

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
 * @datetime 2018-08-09 22:47:05
*/
@RestController
@RequestMapping("sysuserrole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysUserRoleService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/userId")
    public R info(@PathVariable("userId") Long userId) {
        SysUserRoleEntity sysUserRole = sysUserRoleService.selectById(userId);
        return R.success().put("data", sysUserRole);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysUserRoleEntity sysUserRole) {
        sysUserRoleService.insert(sysUserRole);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysUserRoleEntity sysUserRole) {
        ValidatorUtils.validateEntity(sysUserRole);
        sysUserRoleService.updateAllColumnById(sysUserRole);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] userIds) {
        sysUserRoleService.deleteBatchIds(Arrays.asList(userIds));
        return R.success();
    }
}
