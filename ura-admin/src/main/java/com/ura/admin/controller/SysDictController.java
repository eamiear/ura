package com.ura.admin.controller;

import com.ura.admin.annotation.SysLog;
import com.ura.admin.entity.SysDictEntity;
import com.ura.admin.service.SysDictService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 数据字典表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-12 16:02:57
*/
@RestController
@RequestMapping("sys/dict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    @SysLog("查询字典列表")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysDictService.queryPage(params);
        return R.success().put("data", page);
    }

    @SysLog("查询字典记录")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        SysDictEntity sysDict = sysDictService.selectById(id);
        return R.success().put("data", sysDict);
    }

    @SysLog("新增字典")
    @RequestMapping("/save")
    public R save (@RequestBody SysDictEntity sysDict) {
        sysDictService.insert(sysDict);
        return R.success();
    }

    @SysLog("修改字典")
    @RequestMapping("/update")
    public R update ( @RequestBody SysDictEntity sysDict) {
        ValidatorUtils.validateEntity(sysDict);
        sysDictService.updateAllColumnById(sysDict);
        return R.success();
    }

    @SysLog("删除字典记录")
    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] ids) {
        sysDictService.deleteBatchIds(Arrays.asList(ids));
        return R.success();
    }
}
