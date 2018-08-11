package com.ura.admin.controller;

import com.ura.admin.entity.SysDeptEntity;
import com.ura.admin.service.SysDeptService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 部门表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-11 19:34:31
*/
@RestController
@RequestMapping("sysdept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysDeptService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/deptId")
    public R info(@PathVariable("deptId") Long deptId) {
        SysDeptEntity sysDept = sysDeptService.selectById(deptId);
        return R.success().put("data", sysDept);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysDeptEntity sysDept) {
        sysDeptService.insert(sysDept);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysDeptEntity sysDept) {
        ValidatorUtils.validateEntity(sysDept);
        sysDeptService.updateAllColumnById(sysDept);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] deptIds) {
        sysDeptService.deleteBatchIds(Arrays.asList(deptIds));
        return R.success();
    }
}
