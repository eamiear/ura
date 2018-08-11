package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.admin.annotation.DataFilter;
import com.ura.common.utils.Constant;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ura.admin.dao.SysDeptDao;
import com.ura.admin.entity.SysDeptEntity;
import com.ura.admin.service.SysDeptService;
import org.springframework.stereotype.Service;

@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {

    @Override
    @DataFilter(subDept = true, user = false)
    public List<SysDeptEntity> queryList(Map<String, Object> params) {
        List<SysDeptEntity> deptList = this.selectList(new EntityWrapper<SysDeptEntity>()
                .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER)));

        for (SysDeptEntity deptEntity : deptList) {
            SysDeptEntity parentDept = this.selectById(deptEntity.getParentId());
            if (parentDept != null) {
                deptEntity.setParentName(parentDept.getName());
            }
        }
        return deptList;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysDeptEntity> page = this.selectPage(new Query<SysDeptEntity>(params).getPage(), new EntityWrapper<SysDeptEntity>());
        return new PageUtils(page);
    }

    @Override
    public List<Long> queryDeptIdList(Long parentId) {
        return baseMapper.queryDeptIdList(parentId);
    }

    @Override
    public List<Long> getSubDeptIdList(Long deptId) {
        List<Long> deptIdList = new ArrayList<>();

        List<Long> subIdList = queryDeptIdList(deptId);
        getDeptTreeList(subIdList, deptIdList);
        return deptIdList;
    }

    private void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList) {
        for (Long deptId : subIdList) {
            List<Long> list = queryDeptIdList(deptId);
            if (list.size() > 0) {
                getDeptTreeList(list, deptIdList);
            }
            deptIdList.add(deptId);
        }
    }
}