package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ura.admin.dao.SysRoleDeptDao;
import com.ura.admin.entity.SysRoleDeptEntity;
import com.ura.admin.service.SysRoleDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptDao, SysRoleDeptEntity> implements SysRoleDeptService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleDeptEntity> page = this.selectPage(new Query<SysRoleDeptEntity>(params).getPage(), new EntityWrapper<SysRoleDeptEntity>());
        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        deleteBatch(new Long[]{roleId});

        if (deptIdList.size() == 0) {
            return ;
        }
        List<SysRoleDeptEntity> list = new ArrayList<>();
        for (Long deptId : deptIdList) {
            SysRoleDeptEntity roleDeptEntity = new SysRoleDeptEntity();
            roleDeptEntity.setDeptId(deptId);
            roleDeptEntity.setRoleId(roleId);
            list.add(roleDeptEntity);
        }

        this.insertBatch(list);
    }

    @Override
    public List<Long> queryDeptIdList(Long[] roleIds) {
        return baseMapper.queryDeptIdList(roleIds);
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }
}