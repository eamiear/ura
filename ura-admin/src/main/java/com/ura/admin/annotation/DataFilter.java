package com.ura.admin.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataFilter {
  String tableAlias() default "";

  boolean user() default true;

  boolean subDept() default false;

  String deptId() default "dept_id";

  String userId() default "user_id";
}
