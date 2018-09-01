package com.ura.common.utils;

import com.alibaba.fastjson.JSONObject;

public class JSONResult extends JSONObject {
  public JSONObject JSONResult() {
    return new JSONObject();
  }

  public static JSONResult add(String key, Object value) {
    JSONResult r = new JSONResult();
    return r.put(key, value);
  }
  public JSONResult put (String key, Object value) {
    super.put(key, value);
    return this;
  }
}
