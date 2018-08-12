package com.ura.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.admin.entity.SysDictEntity;
import java.util.Map;

/**
* 数据字典表
 * @author eamiear
 * @datetime 2018-08-12 16:02:57
 */
public interface SysDictService extends IService<SysDictEntity> {
    PageUtils queryPage(Map<String, Object> params);
}