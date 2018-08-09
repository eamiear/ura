/**
 * @author eamiear
 * @date 2018/8/9 14:53
 */

package com.ura.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ura.admin.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity>{
    SysUserTokenEntity queryByToken(String token);
}
