/**
 * @author eamiear
 * @date 2018/8/9 15:02
 */

package com.ura.admin.service;

import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.entity.SysUserTokenEntity;

import java.util.Set;

public interface ShiroService {

    Set<String> getUserPermissions(Long userId);

    SysUserTokenEntity queryByToken(String token);

    SysUserEntity queryUser(Long userId);
}
