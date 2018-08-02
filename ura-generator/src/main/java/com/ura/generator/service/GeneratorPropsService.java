/**
 * @author eamiear
 * @date 2018/8/2 9:40
 */

package com.ura.generator.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.common.utils.PageUtils;
import com.ura.generator.entity.PropsEntity;

import java.util.Map;

public interface GeneratorPropsService extends IService<PropsEntity>{
    PageUtils queryPropsList(Map<String, Object> map);

    public boolean save(PropsEntity props);

    public boolean update(PropsEntity props);

    public boolean delete(Long id);

    public boolean deleteById(Long id);
}
