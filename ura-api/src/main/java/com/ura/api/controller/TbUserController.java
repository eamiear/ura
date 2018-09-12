package com.ura.api.controller;

import com.ura.api.entity.TbUserEntity;
import com.ura.api.service.TbUserService;

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
 * @datetime 2018-09-12 17:46:35
*/
@RestController
@RequestMapping("tbuser")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = tbUserService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId) {
        TbUserEntity tbUser = tbUserService.selectById(userId);
        return R.success().put("data", tbUser);
    }

    @RequestMapping("/save")
    public R save (@RequestBody TbUserEntity tbUser) {
        tbUserService.insert(tbUser);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody TbUserEntity tbUser) {
        ValidatorUtils.validateEntity(tbUser);
        tbUserService.updateAllColumnById(tbUser);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] userIds) {
        tbUserService.deleteBatchIds(Arrays.asList(userIds));
        return R.success();
    }
}
