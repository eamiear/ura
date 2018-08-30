package com.ura.admin.controller;

import com.ura.admin.annotation.SysLog;
import com.ura.admin.entity.SysMenuEntity;
import com.ura.admin.service.SysMenuService;

import com.ura.common.utils.Constant;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.exception.URAException;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions("sys:menu:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysMenuService.queryPage(params);
        return R.success().put("data", page);
    }

    @RequestMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public R select () {
        List<SysMenuEntity> menuList = sysMenuService.queryListNotButtonList();

        SysMenuEntity root = new SysMenuEntity();
        root.setMenuId(0L);
        root.setName("一级菜单");
        root.setParentId(-1L);
        root.setShow(true);
        menuList.add(root);

        return R.success().put("data", menuList);
    }

    @SysLog("查询菜单记录")
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    public R info(@PathVariable("menuId") Long menuId) {
        SysMenuEntity sysMenu = sysMenuService.selectById(menuId);
        return R.success().put("data", sysMenu);
    }

    @SysLog("新增菜单")
    @RequestMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public R save (@RequestBody SysMenuEntity sysMenu) {
        validateMenuModel(sysMenu);
        sysMenuService.insert(sysMenu);
        return R.success();
    }

    @SysLog("修改菜单")
    @RequestMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public R update ( @RequestBody SysMenuEntity sysMenu) {
        validateMenuModel(sysMenu);
        sysMenuService.updateAllColumnById(sysMenu);
        return R.success();
    }

    @SysLog("删除菜单")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    public R delete (@RequestBody Long[] menuIds) {
        for (Long menuId :
                menuIds) {
            if (menuId <= Constant.SYS_MENU) {
                return R.error("系统菜单，不能删除");
            }

            List<SysMenuEntity> menuList = sysMenuService.queryListByParentId(menuId);
            if (menuList.size() > 0 ) {
                return R.error("请先删除子菜单");
            }
        }
        sysMenuService.deleteBatchIds(Arrays.asList(menuIds));
        return R.success();
    }

    @SysLog("删除菜单")
    @RequestMapping("/delete/{menuId}")
    @RequiresPermissions("sys:menu:delete")
    public R delete (@PathVariable("menuId") long menuId) {
        if (menuId <= Constant.SYS_MENU) {
            return R.error("系统菜单，不能删除");
        }

        List<SysMenuEntity> menuList = sysMenuService.queryListByParentId(menuId);
        if (menuList.size() > 0 ) {
            return R.error("请先删除子菜单");
        }
        sysMenuService.delete(menuId);
        return R.success();
    }

    public void validateMenuModel (SysMenuEntity menu) {
        if (StringUtils.isBlank(menu.getName())) {
            throw new URAException("菜单名称不能为空");
        }

        if (menu.getParentId() == null) {
            throw new URAException("上级菜单不能为空");
        }

        if (menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new URAException("菜单URL不能为空");
            }
        }

        int parentType = Constant.MenuType.CATALOG.getValue();
        if (menu.getParentId() != 0) {
            SysMenuEntity parentMenu = sysMenuService.selectById(menu.getParentId());
            parentType = parentMenu.getType();
        }

        if (menu.getType() == Constant.MenuType.CATALOG.getValue() || menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (parentType != Constant.MenuType.CATALOG.getValue()) {
                throw new URAException("上级菜单只能为目录类型");
            }
            return;
        }

        if (menu.getType() == Constant.MenuType.BUTTON.getValue()) {
            if (parentType != Constant.MenuType.MENU.getValue()) {
                throw new URAException("上级菜单只能为菜单类型");
            }
            return;
        }

    }

}
