package com.ura.admin.controller;

import com.ura.admin.annotation.SysLog;
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
public class SysMenuController extends AbstractController{
    @Autowired
    private SysMenuService sysMenuService;

    @SysLog("查询树形菜单")
    @RequestMapping("/nav")
    public R nav() {
        List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());
        return R.success().put("list", menuList);
    }
    @SysLog("查询菜单列表")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysMenuService.queryPage(params);
        return R.success().put("data", page);
    }

    @SysLog("查询菜单记录")
    @RequestMapping("/info/{menuId}")
    public R info(@PathVariable("menuId") Long menuId) {
        SysMenuEntity sysMenu = sysMenuService.selectById(menuId);
        return R.success().put("data", sysMenu);
    }

    @SysLog("新增菜单")
    @RequestMapping("/save")
    public R save (@RequestBody SysMenuEntity sysMenu) {
        sysMenuService.insert(sysMenu);
        return R.success();
    }

    @SysLog("修改菜单")
    @RequestMapping("/update")
    public R update ( @RequestBody SysMenuEntity sysMenu) {
        ValidatorUtils.validateEntity(sysMenu);
        sysMenuService.updateAllColumnById(sysMenu);
        return R.success();
    }

    @SysLog("删除菜单")
    @RequestMapping("/delete")
    public R delete (@RequestBody Long[] menuIds) {
        sysMenuService.deleteBatchIds(Arrays.asList(menuIds));
        return R.success();
    }
}
