package com.ura.admin.controller;

import com.ura.admin.entity.SysUserDeptEntity;
import com.ura.admin.service.SysUserDeptService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 用户部门关联表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-11 19:34:31
*/
@RestController
@RequestMapping("sysuserdept")
public class SysUserDeptController {
    @Autowired
    private SysUserDeptService sysUserDeptService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysUserDeptService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/userId")
    public R info(@PathVariable("userId") Long userId) {
        SysUserDeptEntity sysUserDept = sysUserDeptService.selectById(userId);
        return R.success().put("data", sysUserDept);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysUserDeptEntity sysUserDept) {
        sysUserDeptService.insert(sysUserDept);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysUserDeptEntity sysUserDept) {
        ValidatorUtils.validateEntity(sysUserDept);
        sysUserDeptService.updateAllColumnById(sysUserDept);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] userIds) {
        sysUserDeptService.deleteBatchIds(Arrays.asList(userIds));
        return R.success();
    }
}
