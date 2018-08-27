package com.ura.admin.controller;

import com.ura.admin.annotation.SysLog;
import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.service.SysUserService;

import com.ura.common.utils.Constant;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.Assert;
import com.ura.common.validator.ValidatorUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* 用户表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-08 23:00:51
*/
@RestController
@RequestMapping("sys/user")
public class SysUserController extends AbstractController{
    @Autowired
    private SysUserService sysUserService;

    @SysLog("查询用户列表")
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public R list(@RequestParam Map<String, Object> params) {
        if (getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }
        PageUtils page = sysUserService.queryPage(params);
        return R.success().put("data", page);
    }


    @SysLog("查询当前用户信息")
    @RequestMapping("/info")
    @RequiresPermissions("sys:user:info")
    public R info(){
        return R.success().put("data", getUser());
    }

    @SysLog("查询用户信息")
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public R info(@PathVariable("userId") Long userId) {
        SysUserEntity sysUser = sysUserService.selectById(userId);
        return R.success().put("data", sysUser);
    }

    @SysLog("新增用户")
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public R save (@RequestBody SysUserEntity sysUser) {
        sysUser.setCreateUserId(getUserId());
        sysUserService.save(sysUser);
        return R.success();
    }

    @SysLog("修改用户信息")
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public R update ( @RequestBody SysUserEntity sysUser) {
        ValidatorUtils.validateEntity(sysUser);

        sysUser.setCreateUserId(getUserId());
        sysUserService.update(sysUser);
        return R.success();
    }

    @SysLog("删除用户")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public R delete (@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, Constant.SUPER_ADMIN)){
            return R.error("系统管理员不能删除");
        }
        if (ArrayUtils.contains(userIds, getUserId())){
            return R.error("当前用户不能删除");
        }
        sysUserService.deleteBatch(userIds);
        return R.success();
    }

    @SysLog("修改密码")
    @RequestMapping("/updatePassword")
    public R password(@RequestParam("password") String password, @RequestParam("newPassword") String newPassword){
        Assert.isBlank(newPassword, "新密码不能为空");
        String passwordEncrypt = new Sha256Hash(password, getUser().getSalt()).toHex();
        String newPasswordEncrypt = new Sha256Hash(newPassword, getUser().getSalt()).toHex();
        boolean flag = sysUserService.updatePassword(getUserId(), passwordEncrypt, newPasswordEncrypt);
        if (!flag) {
            return R.error("原密码不正确");
        }

        return R.success();
    }
}
