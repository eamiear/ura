/**
 * @author eamiear
 * @date 2018/8/3 11:42
 */

package com.ura.common.utils;

public class RedisKeys {

    public static String getSysConfigKey(String key) {
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key) {
        return "sessionid:" + key;
    }

    public static String getGeneratorKey(String key) {
        return "generator:id:" + key;
    }
}