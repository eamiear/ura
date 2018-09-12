package com.ura.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.api.entity.TbTokenEntity;
import java.util.Map;

/**
* 
 * @author eamiear
 * @datetime 2018-09-12 17:46:35
 */
public interface TbTokenService extends IService<TbTokenEntity> {
    PageUtils queryPage(Map<String, Object> params);
}