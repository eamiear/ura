package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
* 用户表
 * @author eamiear
 * @datetime 2018-08-08 23:00:51
 */
public interface SysUserService extends IService<SysUserEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<String> queryAllPermissionsByUserId(Long userId);

    List<Long> queryAllMenuIdByUserId(Long userId);

    SysUserEntity queryByUserName(String userName);

    void save(SysUserEntity user);

    void update(SysUserEntity user);

    void deleteBatch(Long[] userIds);

    boolean updatePassword(Long userId, String password, String newPassword);
}