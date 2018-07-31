/**
 * @author eamiear
 * @date 2018/7/30 16:30
 */

package com.ura.common.utils;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object>{
    public R() {
        put("code", 0);
    }

    public static R error () {
        return error(500, "");
    }

    public static R error (String msg) {
        return error(500, msg);
    }

    public static R error (int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R success () {
        return new R();
    }
    public static R success (String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R success (Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
