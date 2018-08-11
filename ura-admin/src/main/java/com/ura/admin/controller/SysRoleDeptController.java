package com.ura.admin.controller;

import com.ura.admin.entity.SysRoleDeptEntity;
import com.ura.admin.service.SysRoleDeptService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 角色部门表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-11 19:34:31
*/
@RestController
@RequestMapping("sysroledept")
public class SysRoleDeptController {
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysRoleDeptService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/roleId")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRoleDeptEntity sysRoleDept = sysRoleDeptService.selectById(roleId);
        return R.success().put("data", sysRoleDept);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysRoleDeptEntity sysRoleDept) {
        sysRoleDeptService.insert(sysRoleDept);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysRoleDeptEntity sysRoleDept) {
        ValidatorUtils.validateEntity(sysRoleDept);
        sysRoleDeptService.updateAllColumnById(sysRoleDept);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] roleIds) {
        sysRoleDeptService.deleteBatchIds(Arrays.asList(roleIds));
        return R.success();
    }
}
