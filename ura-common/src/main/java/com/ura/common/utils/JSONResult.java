package com.ura.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class JSONResult extends JSONObject {

  private JSONResult() {
    put("timestamp", new Date().getTime());
  }

  public static JSONResult build() {
    return new JSONResult();
  }
  public JSONResult put (String key, Object value) {
    super.put(key, value);
    return this;
  }
}
