package com.ura.admin.controller;

import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.shiro.ShiroUtils;

public abstract class AbstractController {

  protected SysUserEntity getUser(){
    return (SysUserEntity) ShiroUtils.getPrincipal();
  }

  protected Long getUserId(){
    return getUser().getUserId();
  }
}
