/**
 * @author eamiear
 * @date 2018/11/29 13:58
 */

package com.ura.common.constant;

public class AIConstant {
    public static String BD_FACE_APPID = "14981609";
    public static String BD_FACE_APPKEY = "vFdFDzH7ZVlSDgOSRZyvFBZp";
    public static String BD_FACE_APPSECRET = "IMBVuKOc5THlNgO7iGfwEH3IQ3OGbWtm";


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
        public int getValue(){
            return this.value;
        }
    }
}
