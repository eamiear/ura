package com.ura.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.ura.admin.annotation.SysLog;
import com.ura.admin.entity.SysDeptEntity;
import com.ura.admin.service.SysDeptService;

import com.ura.common.utils.Constant;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 部门表
 * @author eamiear
 * @email eamiear@163.com
 * @datetime 2018-08-11 19:34:31
*/
@RestController
@RequestMapping("sys/dept")
public class SysDeptController extends AbstractController{
    @Autowired
    private SysDeptService sysDeptService;

    @SysLog("查询部门列表")
    @RequestMapping("/list")
    @RequiresPermissions("sys:dept:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysDeptService.queryPage(params);
        return R.success().put("data", page);
    }

    @SysLog("查询部门列表")
    @RequestMapping("/list")
    @RequiresPermissions("sys:dept:list")
    public R list() {
        List<SysDeptEntity> deptList = sysDeptService.queryList(new HashMap<>());
        return R.success().put("data", deptList);
    }

    @SysLog("查询部门列表")
    @RequestMapping("/select")
    @RequiresPermissions("sys:dept:select")
    public R select() {
        List<SysDeptEntity> deptList = sysDeptService.queryList(new HashMap<>());
        if (getUserId() == Constant.SUPER_ADMIN) {
            SysDeptEntity root = new SysDeptEntity();
            root.setDeptId(0L);
            root.setName("一级部门");
            root.setParentId(-1L);
            root.setOpen(true);
            deptList.add(root);
        }
        return R.success().put("data", deptList);
    }

    @SysLog("查询某部门信息")
    @RequestMapping("/info/{deptId}")
    @RequiresPermissions("sys:dept:info")
    public R info(@PathVariable("deptId") Long deptId) {
        SysDeptEntity sysDept = sysDeptService.selectById(deptId);
        return R.success().put("data", sysDept);
    }

    /**
     * 上级部门Id(管理员则为0)
     * @return
     */
    @RequestMapping("/getParentDeptId")
    @RequiresPermissions("sys:dept:list")
    public R info() {
        long deptId = 0;
        if (getUserId() != Constant.SUPER_ADMIN) {
            List<SysDeptEntity> deptList = sysDeptService.queryList(new HashMap<>());
            Long parentId = null;
            for (SysDeptEntity dept : deptList) {
                if (parentId == null) {
                    parentId = dept.getParentId();
                    continue;
                }
                if (parentId > dept.getParentId().longValue()) {
                    parentId = dept.getParentId();
                }
            }
            deptId = parentId;
        }
        JSONObject json = new JSONObject();
        json.put("deptId", deptId);
        return R.success().put("data", json);
    }

    @SysLog("新增部门")
    @RequestMapping("/save")
    @RequiresPermissions("sys:dept:save")
    public R save (@RequestBody SysDeptEntity sysDept) {
        sysDeptService.insert(sysDept);
        return R.success();
    }

    @SysLog("修改部门")
    @RequestMapping("/update")
    @RequiresPermissions("sys:dept:update")
    public R update ( @RequestBody SysDeptEntity sysDept) {
        ValidatorUtils.validateEntity(sysDept);
        sysDeptService.updateAllColumnById(sysDept);
        return R.success();
    }

    @SysLog("删除部门")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
    public R delete (long deptId) {
        List<Long> deptIdList = sysDeptService.queryDeptIdList(deptId);
        if (deptIdList.size() > 0) {
            return R.error("请先删除子部门");
        }
        sysDeptService.deleteById(deptId);
        return R.success();
    }
}
