/**
 * @author eamiear
 * @date 2018/8/2 9:41
 */

package com.ura.generator.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ura.common.utils.R;
import com.ura.generator.entity.PropsEntity;

public interface GeneratorPropsDao extends BaseMapper<PropsEntity>{
    public boolean deleteById(Long id);
}
