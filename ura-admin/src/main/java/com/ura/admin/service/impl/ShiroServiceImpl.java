/**
 * @author eamiear
 * @date 2018/8/9 15:05
 */

package com.ura.admin.service.impl;

import com.ura.admin.dao.SysMenuDao;
import com.ura.admin.dao.SysUserDao;
import com.ura.admin.dao.SysUserTokenDao;
import com.ura.admin.entity.SysMenuEntity;
import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.entity.SysUserTokenEntity;
import com.ura.admin.service.ShiroService;
import com.ura.common.utils.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    SysUserTokenDao sysUserTokenDao;

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysMenuDao sysMenuDao;

    @Override
    public Set<String> getUserPermissions(Long userId) {
        List<String> permsList;
        if (userId == Constant.SUPER_ADMIN) {
            List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for (SysMenuEntity menu : menuList) {
                permsList.add(menu.getPerms());
            }
        } else {
            permsList = sysUserDao.queryAllPermissionsByUserId(userId);
        }

        Set<String> permsSet = new HashSet<>();
        for (String perms :
                permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
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
