package com.ura.api.service.impl;

import com.google.gson.JsonSyntaxException;
import com.ura.common.config.WechatConfig;
import com.ura.common.constant.SystemConstant;
import com.ura.common.utils.JSONUtils;
import com.ura.common.utils.SysIOUtils;
import com.ura.wechat.constants.QRCodeConstant;
import com.ura.wechat.model.qrcode.WechatQRCode;
import com.ura.wechat.model.qrcode.WechatQRCodeShortUrl;
import com.ura.wechat.model.result.WechatResult;
import com.ura.api.service.WechatQRCodeService;
import com.ura.wechat.utils.HttpReqUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class WebchatQRCodeServiceImpl implements WechatQRCodeService {
  @Override
  public String createTempTicket(String accessToken, int expireSeconds, int sceneId) {
    TreeMap<String, String> params = new TreeMap<>();
    params.put("access_token", accessToken);
    Map<String, Integer> intMap = new HashMap<>();
    intMap.put("scene_id", sceneId);
    Map<String, Object> mapMap = new HashMap<>();
    mapMap.put("scene", intMap);

    Map<String, Object> paramsMap = new HashMap<>();
    paramsMap.put("expire_seconds", expireSeconds);
    paramsMap.put("action_name", QRCodeConstant.QR_SCENE);
    paramsMap.put("action_info", mapMap);
    String data = JSONUtils.toJsonString(paramsMap);
    data = HttpReqUtils.HttpDefaultExecute(SystemConstant.POST_METHOD, WechatConfig.CREATE_TICKET_PATH, params, data, null);
    WechatQRCode wechatQRCode = null;
    try {
      wechatQRCode = JSONUtils.fromJsonString(data, WechatQRCode.class);
    } catch (JsonSyntaxException e){
      e.printStackTrace();
    }
    return wechatQRCode == null ? null : wechatQRCode.getTicket();
  }

  @Override
  public String createForeverTicket(String accessToken, int sceneId) {
    TreeMap<String, String> params = new TreeMap<>();
    params.put("access_token", accessToken);

    Map<String, Integer> intMap = new HashMap<>();
    intMap.put("scene_id", sceneId);
    Map<String, Object> mapMap = new HashMap<>();
    mapMap.put("scene", intMap);

    Map<String, Object> paramsMap = new HashMap<>();
    paramsMap.put("action_name", QRCodeConstant.QR_LIMIT_SCENE);
    paramsMap.put("action_info", mapMap);
    String data = JSONUtils.toJsonString(paramsMap);
    data = HttpReqUtils.HttpDefaultExecute(SystemConstant.POST_METHOD, WechatConfig.CREATE_TICKET_PATH, params, data, null);
    WechatQRCode wechatQRCode = null;
    try {
      wechatQRCode = JSONUtils.fromJsonString(data, WechatQRCode.class);
    } catch (JsonSyntaxException e){
      e.printStackTrace();
    }
    return wechatQRCode == null ? null : wechatQRCode.getTicket();
  }

  @Override
  public String createForeverTicket(String accessToken, String sceneStr) {
    TreeMap<String, String> params = new TreeMap<>();
    params.put("access_token", accessToken);

    Map<String, String> intMap = new HashMap<>();
    intMap.put("scene_str", sceneStr);
    Map<String, Object> mapMap = new HashMap<>();
    mapMap.put("scene", intMap);

    Map<String, Object> paramsMap = new HashMap<>();
    paramsMap.put("action_name", QRCodeConstant.QR_LIMIT_STR_SCENE);
    paramsMap.put("action_info", mapMap);
    String data = JSONUtils.toJsonString(paramsMap);
    data = HttpReqUtils.HttpDefaultExecute(SystemConstant.POST_METHOD, WechatConfig.CREATE_TICKET_PATH, params, data, null);
    WechatQRCode wechatQRCode = null;
    try {
      wechatQRCode = JSONUtils.fromJsonString(data, WechatQRCode.class);
    } catch (JsonSyntaxException e){
      e.printStackTrace();
    }
    return wechatQRCode == null ? null : wechatQRCode.getTicket();
  }

  @Override
  public String showQrcode(String accessToken, String ticket) throws Exception {
    return toShortQRCodeurl(accessToken, HttpReqUtils.setParmas(handleParams(ticket), WechatConfig.SHOW_QRCODE_PATH, null));
  }

  @Override
  public WechatResult downloadQrcode(String ticket, String savePath) throws Exception {
    return HttpReqUtils.downMeaterMetod(handleParams(ticket), SystemConstant.GET_METHOD, WechatConfig.SHOW_QRCODE_PATH, savePath, null);
  }

  private TreeMap<String, String> handleParams(String ticket){
    TreeMap<String, String> params = new TreeMap<>();
    params.put("ticket", SysIOUtils.urlEncode(ticket, SystemConstant.DEFAULT_CHARACTER_ENCODING));
    return params;
  }

  private String toShortQRCodeurl(String accessToken, String longUrl){
    TreeMap<String, String> params = new TreeMap<>();
    params.put("access_token", accessToken);

    Map<String, Object> paramsMap = new HashMap<>();
    paramsMap.put("action", QRCodeConstant.LONG2SHORT);
    paramsMap.put("long_url", longUrl);
    String data = JSONUtils.toJsonString(paramsMap);
    String result = HttpReqUtils.HttpDefaultExecute(SystemConstant.POST_METHOD, WechatConfig.WECHAT_SHORT_QRCODE_URL, params, data, null);
    WechatQRCodeShortUrl wechatQRCodeShortUrl = JSONUtils.fromJsonString(result, WechatQRCodeShortUrl.class);
    return wechatQRCodeShortUrl.getShort_url();
  }
}
