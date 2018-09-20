package com.ura.common.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
  private static Logger logger = LoggerFactory.getLogger(IPUtils.class);

  public static String getIp(HttpServletRequest request) {
    String ip = null;
    try {
      ip = request.getHeader("x-forwarded-for");
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("Proxy-Client-IP");
      }
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("WL-Proxy-Client-IP");
      }
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("HTTP_CLIENT_IP");
      }
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
      }
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getRemoteAddr();
      }
      // 多级反向代理
      if (StringUtils.isNotEmpty(ip) && ip.indexOf(",") > 0 && ip.split(",").length > 1) {
        ip = ip.split(",")[0];
      }
    } catch (Exception e) {
      logger.error("IPUtils Error ", e);
    }

    return ip;
  }
}
