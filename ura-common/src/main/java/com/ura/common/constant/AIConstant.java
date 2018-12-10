/**
 * @author eamiear
 * @date 2018/11/29 13:58
 */

package com.ura.common.constant;

public class AIConstant {
  // 百度
  public static final String BD_FACE_APPID = "14981609";
  public static final String BD_FACE_APPKEY = "vFdFDzH7ZVlSDgOSRZyvFBZp";
  public static final String BD_FACE_APPSECRET = "IMBVuKOc5THlNgO7iGfwEH3IQ3OGbWtm";
  // 腾讯
  public static final String TECENT_FACE_APPID = "";
  public static final String TECENT_FACE_APPKEY = "";
  // face++
  public static final String FPP_API_KEY = "";
  public static final String FPP_API_SECRET = "";
  public static final String FPP_FACE_DETECT_URL = "https://api-cn.faceplusplus.com/facepp/v3/detect"; // 人脸检测接口地址

  // 优图
  public static final String YOUTU_USER_QQ = "";
  public static final String YOUTU_APPID = "";
  public static final String YOUTU_SECRETID = "";
  public static final String YOUTU_SECRET_KEY = "";

  public static final String YT_OCR_HANDWRITING = "https://api.youtu.qq.com/youtu/ocrapi/handwritingocr";//通用手写体文字识别
  public static final String YT_CLASSIFY_HANDTRACKING = "http://api.youtu.qq.com/youtu/handtracking/classify";//自拍场景手势识别
  public static final String YT_FACEDETECT = "http://api.youtu.qq.com/youtu/api/detectface";//人脸检测

  public enum YouTuType {
    HANDWRITING(0),
    HANDTRACKING(1),
    FACEDETECT(2);

    private int value;

    YouTuType(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }
  }

  public enum OcrType {
    BASIC_GENERAL(0),//通用文字识别
    BASIC_ACCURATE_GENERAL(1),//通用文字识别（高精度版）
    GENERAL(2),//通用文字识别（含位置信息版）
    ACCURATE_GENERAL(3),//通用文字识别（含位置高精度版）
    ENHANCE_GENERAL(4),//通用文字识别（含生僻字版）
    WEB_IMAGE(5),//网络图片文字识别
    IDCARD(6),//身份证识别
    BANKCARD(7),//银行卡识别
    DRIVING_LICENSE(8),//驾驶证识别
    VEHICLE_LICENSE(9),//行驶证识别
    PLATE_LICENSE(10),//车牌识别
    BUSINESS_LICENSE(11),//营业执照识别
    RECEIPT(12),//通用票据识别
    CUSTOM(13),//自定义模版文字识别
    FORM(14),//表格文字识别同步接口
    HANDWRITING(15);// 手写

    private int value;

    OcrType(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }
  }
}
