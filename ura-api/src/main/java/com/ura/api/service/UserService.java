package com.ura.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.api.bean.LoginBean;
import com.ura.common.utils.PageUtils;
import com.ura.api.entity.UserEntity;
import java.util.Map;

/**
* 
 * @author eamiear
 * @datetime 2018-09-12 17:46:35
 */
public interface UserService extends IService<UserEntity> {
    UserEntity queryByMobile(String mobile);

    UserEntity queryByOpenId(String openId);

    Map<String, Object> login(String mobile, String password);
}