package com.ura.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.api.entity.AppVersionEntity;


/**
* 
 * @author eamiear
 * @datetime 2018-09-26 18:05:21
 */
public interface AppVersionService extends IService<AppVersionEntity> {

    public AppVersionEntity queryLatestVersion();
}