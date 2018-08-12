package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Map;

import com.ura.admin.dao.SysLogDao;
import com.ura.admin.entity.SysLogEntity;
import com.ura.admin.service.SysLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String)params.get("username");
        Page<SysLogEntity> page = this.selectPage(
                new Query<SysLogEntity>(params).getPage(),
                new EntityWrapper<SysLogEntity>()
                        .like(StringUtils.isNotBlank(username), "username", username));
        return new PageUtils(page);
    }
}