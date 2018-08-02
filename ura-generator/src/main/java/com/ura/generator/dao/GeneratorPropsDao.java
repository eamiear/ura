/**
 * @author eamiear
 * @date 2018/8/2 9:41
 */

package com.ura.generator.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ura.generator.entity.PropsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GeneratorPropsDao extends BaseMapper<PropsEntity>{
    boolean deleteById(Long id);
}
