package com.ura.admin.aspect;

import com.ura.admin.annotation.DataFilter;
import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.service.SysDeptService;
import com.ura.admin.service.SysRoleDeptService;
import com.ura.admin.service.SysUserRoleService;
import com.ura.common.utils.Constant;
import com.ura.common.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Aspect
@Component
public class DataFilterAspect {

  @Autowired
  private SysUserRoleService sysUserRoleService;

  @Autowired
  private SysRoleDeptService sysRoleDeptService;

  @Autowired
  private SysDeptService sysDeptService;

  @Pointcut("@annotation(com.ura.admin.annotation.DataFilter)")
  public void dataFilterCut() {

  }

  @Before("dataFilterCut()")
  public void dataFilter(JoinPoint point) throws Throwable {
    Object params = point.getArgs()[0];
    if (params != null && params instanceof Map) {
      SysUserEntity user = ShiroUtils.getUser();
      if (user.getUserId() != Constant.SUPER_ADMIN) {
        Map map = (Map)params;
        map.put(Constant.SQL_FILTER, getSQLFilter(user, point));
      }

      return;
    }
  }

  private String getSQLFilter(SysUserEntity user, JoinPoint point) {
    MethodSignature signature = (MethodSignature) point.getSignature();
    DataFilter dataFilter = signature.getMethod().getAnnotation(DataFilter.class);

    String tableAlias = dataFilter.tableAlias();
    if (StringUtils.isNotBlank(tableAlias)) {
      tableAlias += ".";
    }

    Set<Long> deptIdList = new HashSet<>();
    List<Long> roleIdList = sysUserRoleService.queryRoleIdList(user.getUserId());
    if (roleIdList.size() > 0) {
      List<Long> userDeptIdList = sysRoleDeptService.queryDeptIdList(roleIdList.toArray(new Long[roleIdList.size()]));
      deptIdList.addAll(userDeptIdList);
    }

    if (dataFilter.subDept()) {
      List<Long> subDeptIdList = sysDeptService.queryDeptIdList(user.getDeptId());
      deptIdList.addAll(subDeptIdList);
    }

    StringBuilder sqlFilter = new StringBuilder();
    sqlFilter.append(" (");

    if (deptIdList.size() > 0) {
      sqlFilter.append(tableAlias).append(dataFilter.deptId()).append("in(").append(StringUtils.join(deptIdList, ",")).append(")");
    }

    if (dataFilter.user()) {
      if (deptIdList.size() > 0) {
        sqlFilter.append("or");
      }
      sqlFilter.append(tableAlias).append(dataFilter.userId()).append("=").append(user.getUserId());
    }
    sqlFilter.append(")");

    return sqlFilter.toString();
  }
}
