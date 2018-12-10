/**
 * @author eamiear
 * @date 2018/12/10 14:16
 */

package com.ura.ai.common;

import java.util.HashMap;
import java.util.Map;

public class HandTrackEnum {
  public static String getLabelName(String label) throws Exception {
    Map<String, String> labelMap = new HashMap<>();
    labelMap.put("1", "1");
    labelMap.put("6", "6");
    labelMap.put("SIX", "6");
    labelMap.put("8", "8");
    labelMap.put("EIGHT", "8");
    labelMap.put("FIST", "拳头");
    labelMap.put("HEART", "比心");
    labelMap.put("LIFT", "托");
    labelMap.put("LIKE", "点赞");
    labelMap.put("LOVE", "我爱你");
    labelMap.put("OK", "OK");
    labelMap.put("PAPER", "布");
    labelMap.put("ROCK", "摇滚手势");
    labelMap.put("SCISSOR", "剪刀");
    labelMap.put("ONE", "食指");
    return labelMap.get(label);
  }
}
