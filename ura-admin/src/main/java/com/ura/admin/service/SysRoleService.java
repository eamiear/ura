package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysRoleEntity;
import java.util.Map;

/**
* 角色表
 * @author eamiear
 * @datetime 2018-08-09 22:47:06
 */
public interface SysRoleService extends IService<SysRoleEntity> {
    PageUtils queryPage(Map<String, Object> params);
}