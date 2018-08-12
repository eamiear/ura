package com.ura.admin.controller;

import com.ura.admin.entity.SysLogEntity;
import com.ura.admin.service.SysLogService;

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
 * @datetime 2018-08-12 16:02:57
*/
@RestController
@RequestMapping("syslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysLogService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        SysLogEntity sysLog = sysLogService.selectById(id);
        return R.success().put("data", sysLog);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysLogEntity sysLog) {
        sysLogService.insert(sysLog);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysLogEntity sysLog) {
        ValidatorUtils.validateEntity(sysLog);
        sysLogService.updateAllColumnById(sysLog);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] ids) {
        sysLogService.deleteBatchIds(Arrays.asList(ids));
        return R.success();
    }
}
