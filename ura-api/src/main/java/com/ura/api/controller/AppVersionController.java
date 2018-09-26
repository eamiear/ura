package com.ura.api.controller;

import com.ura.api.entity.AppVersionEntity;
import com.ura.api.service.AppVersionService;

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
 * @datetime 2018-09-26 18:05:21
*/
@RestController
@RequestMapping("appversion")
public class AppVersionController {
    @Autowired
    private AppVersionService appVersionService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
//        PageUtils page = appVersionService.queryPage(params);
//        return R.success().put("data", page);
        return R.success();
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        AppVersionEntity appVersion = appVersionService.selectById(id);
        return R.success().put("data", appVersion);
    }

    @RequestMapping("/save")
    public R save (@RequestBody AppVersionEntity appVersion) {
        appVersionService.insert(appVersion);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody AppVersionEntity appVersion) {
        ValidatorUtils.validateEntity(appVersion);
        appVersionService.updateAllColumnById(appVersion);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] ids) {
        appVersionService.deleteBatchIds(Arrays.asList(ids));
        return R.success();
    }
}
