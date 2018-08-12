package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysLogEntity;
import java.util.Map;

/**
* 
 * @author eamiear
 * @datetime 2018-08-12 16:02:57
 */
public interface SysLogService extends IService<SysLogEntity> {
    PageUtils queryPage(Map<String, Object> params);
}