package com.ura.admin.aspect;

import com.alibaba.fastjson.JSON;
import com.ura.admin.annotation.SysLog;
import com.ura.admin.entity.SysLogEntity;
import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.service.SysLogService;
import com.ura.common.utils.HttpContextUtils;
import com.ura.common.utils.IPUtils;
import com.ura.common.utils.ShiroUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class SysLogAspect {

  @Autowired
  private SysLogService sysLogService;

  @Pointcut("@annotation(com.ura.admin.annotation.SysLog)")
  public void logPointCut() {

  }

  @Around("logPointCut()")
  public Object around(ProceedingJoinPoint point) throws Throwable {
    long beginTime = System.currentTimeMillis();
    Object result = point.proceed();
    long time = System.currentTimeMillis() - beginTime;

    saveSysLog(point, time);
    return result;
  }

  private void saveSysLog(ProceedingJoinPoint point, long time) {
    MethodSignature signature = (MethodSignature)point.getSignature();
    Method method = signature.getMethod();

    SysLogEntity sysLog = new SysLogEntity();
    SysLog syslog = method.getAnnotation(SysLog.class);
    if (sysLog != null) {
      sysLog.setOperation(syslog.value());
    }

    String className = point.getTarget().getClass().getName();
    String methodName = signature.getName();
    sysLog.setMethod(className + "." + methodName + "()");

    Object[] args = point.getArgs();
    try{
      String params = JSON.toJSONString(args[0]);
      sysLog.setParams(params);
    } catch (Exception e){}

    HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
    sysLog.setIp(IPUtils.getIp(request));

    String username = ((SysUserEntity)ShiroUtils.getPrincipal()).getUsername();
    sysLog.setUsername(username);

    sysLog.setTime(String.valueOf(time));
    sysLog.setCreateTime(new Date());

    sysLogService.insert(sysLog);
  }
}
