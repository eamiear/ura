package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ura.admin.dao.SysRoleDao;
import com.ura.admin.entity.SysRoleEntity;
import com.ura.admin.service.SysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName = (String)params.get("roleName");
        Long createUserId = (Long)params.get("createUserId");
        Page<SysRoleEntity> page = this.selectPage(
                new Query<SysRoleEntity>(params).getPage(),
                new EntityWrapper<SysRoleEntity>()
                        .like(StringUtils.isNotBlank(roleName), "role_name", roleName)
                        .eq(createUserId != null, "create_user_id", createUserId));
        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleEntity role) {
        role.setCreateTime(new Date());
        this.insert(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleEntity role) {
        this.updateById(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
      this.deleteBatchIds(Arrays.asList(roleIds));
    }

    @Override
    public List<Long> queryRoleIdList(Long createUserId) {
        return baseMapper.queryRoleIdList(createUserId);
    }
}