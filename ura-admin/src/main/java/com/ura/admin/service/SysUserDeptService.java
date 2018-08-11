package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysUserDeptEntity;
import java.util.Map;

/**
* 用户部门关联表
 * @author eamiear
 * @datetime 2018-08-11 19:34:31
 */
public interface SysUserDeptService extends IService<SysUserDeptEntity> {
    PageUtils queryPage(Map<String, Object> params);
}