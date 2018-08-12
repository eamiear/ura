package com.ura.admin.controller;

import com.ura.admin.annotation.SysLog;
import com.ura.admin.entity.SysRoleEntity;
import com.ura.admin.service.SysRoleService;

import com.ura.common.utils.Constant;
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
@RequestMapping("sys/role")
public class SysRoleController extends AbstractController{
    @Autowired
    private SysRoleService sysRoleService;

    @SysLog("查询角色列表")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }
        PageUtils page = sysRoleService.queryPage(params);
        return R.success().put("data", page);
    }

    @SysLog("查询角色记录")
    @RequestMapping("/info/{roleId}")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRoleEntity sysRole = sysRoleService.selectById(roleId);
        return R.success().put("data", sysRole);
    }

    @SysLog("新增角色")
    @RequestMapping("/save")
    public R save (@RequestBody SysRoleEntity sysRole) {
        sysRole.setCreateUserId(getUserId());
        sysRoleService.save(sysRole);
        return R.success();
    }


    @SysLog("修改角色")
    @RequestMapping("/update")
    public R update ( @RequestBody SysRoleEntity sysRole) {
        ValidatorUtils.validateEntity(sysRole);
        sysRole.setCreateUserId(getUserId());
        sysRoleService.update(sysRole);
        return R.success();
    }


    @SysLog("删除角色")
    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);
        return R.success();
    }
}
