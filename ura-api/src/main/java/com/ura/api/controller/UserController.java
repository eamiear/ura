package com.ura.api.controller;

import com.ura.api.entity.UserEntity;
import com.ura.api.service.UserService;

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
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = userService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId) {
        UserEntity tbUser = userService.selectById(userId);
        return R.success().put("data", tbUser);
    }

    @RequestMapping("/save")
    public R save (@RequestBody UserEntity tbUser) {
        userService.insert(tbUser);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody UserEntity tbUser) {
        ValidatorUtils.validateEntity(tbUser);
        userService.updateAllColumnById(tbUser);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] userIds) {
        userService.deleteBatchIds(Arrays.asList(userIds));
        return R.success();
    }
}
