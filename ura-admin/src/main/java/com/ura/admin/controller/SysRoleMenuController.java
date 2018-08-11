package com.ura.admin.controller;

import com.ura.admin.entity.SysRoleMenuEntity;
import com.ura.admin.service.SysRoleMenuService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 角色菜单关联表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-11 19:34:31
*/
@RestController
@RequestMapping("sysrolemenu")
public class SysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysRoleMenuService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/roleId")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRoleMenuEntity sysRoleMenu = sysRoleMenuService.selectById(roleId);
        return R.success().put("data", sysRoleMenu);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysRoleMenuEntity sysRoleMenu) {
        sysRoleMenuService.insert(sysRoleMenu);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysRoleMenuEntity sysRoleMenu) {
        ValidatorUtils.validateEntity(sysRoleMenu);
        sysRoleMenuService.updateAllColumnById(sysRoleMenu);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] roleIds) {
        sysRoleMenuService.deleteBatchIds(Arrays.asList(roleIds));
        return R.success();
    }
}
