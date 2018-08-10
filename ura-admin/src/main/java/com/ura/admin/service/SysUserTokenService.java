package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysUserTokenEntity;
import com.ura.common.utils.R;

import java.util.Map;

/**
* 
 * @author eamiear
 * @datetime 2018-08-10 17:03:53
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {
    PageUtils queryPage(Map<String, Object> params);

    R createToken(Long userId);

    void updateToken(Long userId);
}