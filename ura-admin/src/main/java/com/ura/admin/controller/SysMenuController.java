package com.ura.admin.controller;

import com.ura.admin.entity.SysMenuEntity;
import com.ura.admin.service.SysMenuService;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
* 系统菜单
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-06 20:54:28
*/
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("/nav")
    public R nav() {
        List<SysMenuEntity> menuList = sysMenuService.getUserMenuList();
        return R.success().put("list", menuList);
    }
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysMenuService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/info/{menuId}")
    public R info(@PathVariable("menuId") Long menuId) {
        SysMenuEntity sysMenu = sysMenuService.selectById(menuId);
        return R.success().put("data", sysMenu);
    }

    @RequestMapping("/save")
    public R save (@RequestBody SysMenuEntity sysMenu) {
        sysMenuService.insert(sysMenu);
        return R.success();
    }

    @RequestMapping("/update")
    public R update ( @RequestBody SysMenuEntity sysMenu) {
        ValidatorUtils.validateEntity(sysMenu);
        sysMenuService.updateAllColumnById(sysMenu);
        return R.success();
    }

    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] menuIds) {
        sysMenuService.deleteBatchIds(Arrays.asList(menuIds));
        return R.success();
    }
}
