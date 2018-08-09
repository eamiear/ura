/**
 * @author eamiear
 * @date 2018/8/9 15:05
 */

package com.ura.admin.service.impl;

import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.entity.SysUserTokenEntity;
import com.ura.admin.service.ShiroService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {
    @Override
    public Set<String> getUserPermissions(Long userId) {
        return null;
    }

    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return null;
    }

    @Override
    public SysUserEntity queryUser(Long userId) {
        return null;
    }
}
