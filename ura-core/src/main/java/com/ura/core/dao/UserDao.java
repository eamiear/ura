package com.ura.core.dao;

import com.ura.core.entity.UserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
* 
 * @author eamiear
 * @datetime 2018-09-12 17:46:35
*/
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}