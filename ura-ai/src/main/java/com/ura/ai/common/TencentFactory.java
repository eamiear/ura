/**
 * @author eamiear
 * @date 2018/12/6 14:42
 */

package com.ura.ai.common;

import com.ura.common.constant.AIConstant;
import com.ura.taip.face.TAipFace;
import com.ura.taip.imageclassify.TAipImageClassify;
import com.ura.taip.nlp.TAipNlp;
import com.ura.taip.ocr.TAipOcr;
import com.ura.taip.ptu.TAipPtu;
import com.ura.taip.speech.TAipSpeech;
import com.ura.taip.vision.TAipVision;

public class TencentFactory {
  private static TAipFace tAipFace;
  private static TAipPtu tAipPtu;
  private static TAipImageClassify tAipImage;
  private static TAipNlp tAipNlp;
  private static TAipOcr tAipOcr;
  private static TAipSpeech tAipSpeech;
  private static TAipVision tAipVision;

  public static TAipFace createTAipFace() {
    if (tAipFace == null) {
      tAipFace = new TAipFace(AIConstant.TECENT_FACE_APPID, AIConstant.TECENT_FACE_APPKEY);
    }
    return tAipFace;
  }

  public static TAipPtu createTAipPtu() {
    if (tAipPtu == null) {
      tAipPtu = new TAipPtu(AIConstant.TECENT_FACE_APPID, AIConstant.TECENT_FACE_APPKEY);
    }
    return tAipPtu;
  }

  public static TAipOcr createTAipOcr() {
    if (tAipOcr == null) {
      tAipOcr = new TAipOcr(AIConstant.TECENT_FACE_APPID, AIConstant.TECENT_FACE_APPKEY);
    }
    return tAipOcr;
  }

  public static TAipImageClassify createTAipImage() {
    if (tAipImage == null) {
      tAipImage = new TAipImageClassify(AIConstant.TECENT_FACE_APPID, AIConstant.TECENT_FACE_APPKEY);
    }
    return tAipImage;
  }

  public static TAipNlp createTAipNlp() {
    if (tAipNlp == null) {
      tAipNlp = new TAipNlp(AIConstant.TECENT_FACE_APPID, AIConstant.TECENT_FACE_APPKEY);
    }
    return tAipNlp;
  }

  public static TAipSpeech createTAipSpeech() {
    if (tAipSpeech == null) {
      tAipSpeech = new TAipSpeech(AIConstant.TECENT_FACE_APPID, AIConstant.TECENT_FACE_APPKEY);
    }
    return tAipSpeech;
  }

  public static TAipVision createTAipVision() {
    if (tAipVision == null) {
      tAipVision = new TAipVision(AIConstant.TECENT_FACE_APPID, AIConstant.TECENT_FACE_APPKEY);
    }
    return tAipVision;
  }
}
