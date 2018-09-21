package com.ura.common.utils;

import com.ura.common.constant.SystemConstant;
import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;

public class MD5Utils {
  private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

  private static String byteArrayToHexString(byte b[]){
    StringBuffer buffer = new StringBuffer();
    for (byte _b :
            b) {
      buffer.append(byteToHexString(_b));
    }
    return buffer.toString();
  }

  private static String byteToHexString(byte b){
    int n = b;
    if (n < 0) n += 256;
    int d1 = n / 16;
    int d2 = n % 16;
    return hexDigits[d1] + hexDigits[d2];
  }

  public static String MD5Encode(String origin, String charsetname){
    String resultString = null;
    try {
      resultString = origin;
      MessageDigest md = MessageDigest.getInstance("MD5");
      if (StringUtils.isEmpty(charsetname)){
        resultString = byteArrayToHexString(md.digest(resultString.getBytes(SystemConstant.DEFAULT_CHARACTER_ENCODING)));
      } else {
        resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
      }
    } catch (Exception e){
      e.printStackTrace();
    }
    return resultString;
  }
}
