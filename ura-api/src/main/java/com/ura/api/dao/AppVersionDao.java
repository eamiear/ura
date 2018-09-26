package com.ura.api.dao;

import com.ura.api.entity.AppVersionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
* 
 * @author eamiear
 * @datetime 2018-09-26 18:05:21
*/
@Mapper
public interface AppVersionDao extends BaseMapper<AppVersionEntity> {
    public AppVersionEntity queryLatestVersion();
}