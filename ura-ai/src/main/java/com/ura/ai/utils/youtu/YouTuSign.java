/**
 * @author eamiear
 * @date 2018/12/10 11:17
 */

package com.ura.ai.utils.youtu;

import org.springframework.util.Base64Utils;

import java.util.Date;

public class YouTuSign {
  /**
   * Authorization方法
   *
   * @param userQQ    开发者创建应用时的QQ号
   * @param AppID     开发者创建应用后的AppID
   * @param SecretID  开发者创建应用后的SecretID
   * @param SecretKey 开发者创建应用后的SecretKey
   * @return sign
   * @throws Exception
   */
  public static String getSign(String userQQ, String AppID, String SecretID, String SecretKey) throws Exception {
    long tnowTimes = new Date().getTime() / 1000;
    long enowTimes = tnowTimes + 2592000;
    String rRandomNum = HMACSHA1.genRandomNum(10);
    String param = "u=" + userQQ + "&a=" + AppID + "&k=" + SecretID + "&e="
      + enowTimes + "&t=" + tnowTimes + "&r=" + rRandomNum + "&f=";
    byte[] hmacSign = HMACSHA1.getSignature(param, SecretKey);
    byte[] all = new byte[hmacSign.length + param.getBytes().length];
    System.arraycopy(hmacSign, 0, all, 0, hmacSign.length);
    System.arraycopy(param.getBytes(), 0, all, hmacSign.length, param.getBytes().length);
    String sign = Base64Utils.encode(all).toString();
    return sign;
  }
}