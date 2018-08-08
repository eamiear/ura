package com.ura.admin.dao;

import com.ura.admin.entity.SysMenuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 系统菜单
 * @author eamiear
 * @datetime 2018-08-06 20:54:28
*/
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {
    List<SysMenuEntity> queryListByParentId(Long parentId);

    List<SysMenuEntity> queryNotButtonList();
}