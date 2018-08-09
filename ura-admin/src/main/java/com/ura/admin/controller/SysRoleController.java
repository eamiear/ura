package com.ura.admin.controller;

import com.ura.admin.entity.SysRoleEntity;
import com.ura.admin.service.SysRoleService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 角色表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-09 22:47:06
*/
@RestController
@RequestMapping("sysrole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysRoleService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/roleId")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRoleEntity sysRole = sysRoleService.selectById(roleId);
        return R.success().put("data", sysRole);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysRoleEntity sysRole) {
        sysRoleService.insert(sysRole);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysRoleEntity sysRole) {
        ValidatorUtils.validateEntity(sysRole);
        sysRoleService.updateAllColumnById(sysRole);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatchIds(Arrays.asList(roleIds));
        return R.success();
    }
}
