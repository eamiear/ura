package com.ura.ai.common;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.ocr.AipOcr;
import com.ura.common.constant.AIConstant;

public class BaiduFactory {
  private static AipFace aipFace;
  private static AipOcr aipOcr;
  private static AipImageClassify aipImageClassify;

  public static AipFace getAipFace() {
    if (aipFace == null) {
      synchronized (AipFace.class) {
        if (aipFace == null) {
          aipFace = new AipFace(AIConstant.BD_FACE_APPID, AIConstant.BD_FACE_APPKEY, AIConstant.BD_FACE_APPSECRET);
        }
      }
    }
    return aipFace;
  }

  public static AipOcr getAipOcr() {
    if (aipOcr == null) {
      synchronized (AipOcr.class) {
        if (aipOcr == null) {
//          aipOcr = new AipOcr(AIConstant.BD_FACE_APPID)
        }
      }
    }
    return aipOcr;
  }

  public static AipImageClassify getAipImageClassify() {
    if (aipImageClassify == null) {
      synchronized (AipImageClassify.class) {
        if (aipImageClassify == null) {

        }
      }
    }
    return aipImageClassify;
  }
}
