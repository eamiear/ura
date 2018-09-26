package com.ura.api.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.ura.api.dao.AppVersionDao;
import com.ura.api.entity.AppVersionEntity;
import com.ura.api.service.AppVersionService;
import org.springframework.stereotype.Service;

@Service("appVersionService")
public class AppVersionServiceImpl extends ServiceImpl<AppVersionDao, AppVersionEntity> implements AppVersionService {

    @Override
    public AppVersionEntity queryLatestVersion() {
        return baseMapper.queryLatestVersion();
    }
}