package com.ura.wechat.utils;

import com.ura.common.constant.SystemConstant;
import com.ura.common.utils.DateUtils;
import com.ura.common.utils.MD5Utils;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class PayUtils {
  public static int buildRandom(int length){
    int num = 1;
    double random = ThreadLocalRandom.current().nextDouble();
    if (random < 0.1){
      random += 0.1;
    }
    for (int i = 0; i < length; i++) {
      num = num * 10;
    }
    return (int)((random * num));
  }

  /**
   * 生成随机字符串
   * @return
   */
  public static String createNonceStr(){
    return MD5Utils.MD5Encode(String.valueOf(ThreadLocalRandom.current().nextInt(10000)), SystemConstant.DEFAULT_CHARACTER_ENCODING);
  }

  /**
   * 生成商户订单号
   * @return
   */
  public static String createOutTradeNo(){
    return DateUtils.format(new Date(), "yyyyMMddHHmmssSSS") + UUID.randomUUID().toString().hashCode();
  }

  public static String createTimeStamp(){
    return String.valueOf(System.currentTimeMillis() / 1000);
  }

  /**
   * 生成支付二维码URL
   * @param params
   * @return
   */
  public static String createPayImageUrl(TreeMap<String, Object> params){
    StringBuffer buffer = new StringBuffer();
    for (Map.Entry<String, Object> entry : params.entrySet()){
      if (entry.getValue() != null){
        buffer.append("&" + entry.getKey() + "=" + entry.getValue());
      }
    }
    return buffer.toString();
  }
}
