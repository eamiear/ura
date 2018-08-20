/**
 * @author eamiear
 * @date 2018/8/9 15:05
 */

package com.ura.admin.service.impl;

import com.ura.admin.dao.SysUserDao;
import com.ura.admin.dao.SysUserTokenDao;
import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.entity.SysUserTokenEntity;
import com.ura.admin.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    SysUserTokenDao sysUserTokenDao;

    @Autowired
    SysUserDao sysUserDao;

    @Override
    public Set<String> getUserPermissions(Long userId) {
        return null;
    }

    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SysUserEntity queryUser(Long userId) {
        return sysUserDao.selectById(userId);
    }
}
