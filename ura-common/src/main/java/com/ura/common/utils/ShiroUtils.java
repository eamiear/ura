/**
 * @author eamiear
 * @date 2018/8/9 16:36
 */

package com.ura.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ShiroUtils {
    private static Logger logger = LoggerFactory.getLogger(ShiroUtils.class);

    public static Session getSession(){
        return getSubject().getSession();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Object getPrincipal(){
        return SecurityUtils.getSubject().getPrincipal();
    }

    public static void setSessionAttribute(Object key, Object value){
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key){
        return getSession().getAttribute(key);
    }

    public static boolean isLogin(){
        return getPrincipal() != null;
    }

    public static void logout(){
        getSubject().logout();
    }

    public static String getKaptcha(String key){
        String kaptcha;
        try{
            kaptcha = getSessionAttribute(key).toString();
            getSession().removeAttribute(key);
        }catch (Exception e){
            return null;
        }
        return kaptcha;
    }
}
