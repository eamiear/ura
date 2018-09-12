package com.ura.api.controller;

import com.ura.api.entity.TbTokenEntity;
import com.ura.api.service.TbTokenService;

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
@RequestMapping("tbtoken")
public class TbTokenController {
    @Autowired
    private TbTokenService tbTokenService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = tbTokenService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId) {
        TbTokenEntity tbToken = tbTokenService.selectById(userId);
        return R.success().put("data", tbToken);
    }

    @RequestMapping("/save")
    public R save (@RequestBody TbTokenEntity tbToken) {
        tbTokenService.insert(tbToken);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody TbTokenEntity tbToken) {
        ValidatorUtils.validateEntity(tbToken);
        tbTokenService.updateAllColumnById(tbToken);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] userIds) {
        tbTokenService.deleteBatchIds(Arrays.asList(userIds));
        return R.success();
    }
}
