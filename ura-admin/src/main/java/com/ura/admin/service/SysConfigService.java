package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysConfigEntity;
import java.util.Map;

/**
* 系统配置
 * @author eamiear
 * @datetime 2018-08-27 13:43:12
 */
public interface SysConfigService extends IService<SysConfigEntity> {
    PageUtils queryPage(Map<String, Object> params);
}