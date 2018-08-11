package com.ura.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.admin.service.SysUserRoleService;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ura.admin.dao.SysUserDao;
import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.service.SysUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Autowired
    SysUserRoleService sysUserRoleService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String)params.get("username");
        Long createUserId = (Long)params.get("createUserId");
        Page<SysUserEntity> page = this.selectPage(
                new Query<SysUserEntity>(params).getPage(),
                new EntityWrapper<SysUserEntity>()
                        .like(StringUtils.isNotBlank(username), "username", username)
                        .eq(createUserId != null, "create_user_id", createUserId));
        return new PageUtils(page);
    }

    @Override
    public List<String> queryAllPermissionsByUserId(Long userId) {
        return baseMapper.queryAllPermissionsByUserId(userId);
    }

    @Override
    public List<Long> queryAllMenuIdByUserId(Long userId) {
        return baseMapper.queryAllMenuIdByUserId(userId);
    }

    @Override
    public SysUserEntity queryByUserName(String userName) {
        return baseMapper.queryByUserName(userName);
    }

    @Override
    @Transactional
    public void save(SysUserEntity user) {
        user.setCreateTime(new Date());
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
        this.insert(user);

        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    @Transactional
    public void update(SysUserEntity user) {
        if (StringUtils.isBlank(user.getPassword())){
            user.setPassword(null);
        } else {
            user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
        }
        this.updateById(user);

        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    public void deleteBatch(Long[] userIds) {
        this.deleteBatchIds(Arrays.asList(userIds));

        sysUserRoleService.deleteBatch(userIds);
    }

    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new EntityWrapper<SysUserEntity>()
                        .eq("user_id", userId)
                        .eq("password", password));
    }
}