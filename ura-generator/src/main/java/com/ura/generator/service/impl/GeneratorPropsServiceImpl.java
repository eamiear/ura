/**
 * @author eamiear
 * @date 2018/8/2 9:43
 */

package com.ura.generator.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;
import com.ura.generator.dao.GeneratorPropsDao;
import com.ura.generator.entity.PropsEntity;
import com.ura.generator.service.GeneratorPropsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("generatorPropsService")
public class GeneratorPropsServiceImpl extends ServiceImpl<GeneratorPropsDao, PropsEntity> implements GeneratorPropsService {

    @Override
    public PageUtils queryPropsList(Map<String, Object> params) {
        Page<PropsEntity> page = this.selectPage(
                new Query<PropsEntity>(params).getPage(),
                new EntityWrapper<PropsEntity>().eq("status", 0));
        return new PageUtils(page);
    }

    @Override
    public PropsEntity queryPropRecord(Long id) {
        return this.selectOne(new EntityWrapper<PropsEntity>().eq("id", id));
    }

    @Override
    public PropsEntity queryPropRecordByKey(String key) {
        return this.selectOne(new EntityWrapper<PropsEntity>().eq("key", key));
    }

    @Override
    public boolean save(PropsEntity props) {
        return this.insert(props);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(PropsEntity props) {
        return this.updateAllColumnById(props);
    }

    @Override
    public boolean delete(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Long id) {
        return baseMapper.deleteById(id);
    }
}
