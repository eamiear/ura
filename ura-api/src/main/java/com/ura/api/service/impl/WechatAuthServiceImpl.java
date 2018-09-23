package com.ura.api.service.impl;

import com.google.gson.JsonSyntaxException;
import com.ura.api.service.WechatAuthService;
import com.ura.common.config.WechatConfig;
import com.ura.common.constant.SystemConstant;
import com.ura.common.utils.JSONUtils;
import com.ura.wechat.model.base.AbstractParams;
import com.ura.wechat.model.resp.*;
import com.ura.wechat.utils.HttpReqUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class WechatAuthServiceImpl implements WechatAuthService {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 获取授权凭证token
   * @param appid   应用appid
   * @param secret  应用密钥
   * @return
   */
  public String getAccessToken(String appid, String secret){
    TreeMap<String, String> map = new TreeMap<>();
    map.put("grant_type", "client_credential");
    map.put("appid", appid);
    map.put("secret", secret);
    String json = HttpReqUtils.HttpDefaultExecute(SystemConstant.GET_METHOD, WechatConfig.GET_ACCESS_TOKEN_URL, map, "", null);
    String result = null;
    AccessToken accessToken = JSONUtils.fromJsonString(json, AccessToken.class);
    if (accessToken != null) {
      result = accessToken.getAccess_token();
    }
    return result;
  }
  /**
   * 获取授权请求url
   * @param params
   * @param url
   * @return
   * @throws Exception
   */
  @Override
  public String getAuthPath(AbstractParams params, String url) throws Exception {
    Map<String, String> param = params.getParams();
    url = HttpReqUtils.setParmas(param, url, "") + "#wechat_redirect";
    return url;
  }

  /**
   * 获取网页授权凭证
   * @param params
   * @param url
   * @return
   */
  @Override
  public AuthAccessToken getAuthAccessToken(AbstractParams params, String url) {
    AuthAccessToken authAccessToken = null;
    try {
      if (StringUtils.isEmpty(url)){
        url = WechatConfig.GET_OAUTH_TOKEN_URL;
      }
      String result = HttpReqUtils.HttpsDefaultExecute(SystemConstant.GET_METHOD, url, params.getParams(), null, null);
      authAccessToken = JSONUtils.fromJsonString(result, AuthAccessToken.class);
    } catch (Exception e){
      logger.debug("error" + e.getMessage());
    }
    return authAccessToken;
  }

  /**
   * 刷新网页授权验证
   * @param params  参数
   * @param url
   * @return
   */
  @Override
  public AuthAccessToken refreshAuthAccessToken(AbstractParams params, String url) {
    AuthAccessToken authAccessToken = null;
    try{
      if (StringUtils.isEmpty(url)){
        url = WechatConfig.REFRESH_OAUTH_TOKEN_URL;
      }
      String result = HttpReqUtils.HttpDefaultExecute(SystemConstant.GET_METHOD, url, params.getParams(), null, null);
      authAccessToken = JSONUtils.fromJsonString(result, AuthAccessToken.class);
    } catch (Exception e){
      logger.debug("error" + e.getMessage());
    }
    return authAccessToken;
  }

  /**
   * 获取用户信息
   * @param accessToken
   * @param openid
   * @return
   */
  @Override
  public AuthUserInfo getAuthUserInfo(String accessToken, String openid) {
    AuthUserInfo authUserInfo = null;
    Map<String, String> params = new TreeMap<>();
    params.put("openid", openid);
    params.put("access_token", accessToken);
    String result = HttpReqUtils.HttpDefaultExecute(SystemConstant.GET_METHOD, WechatConfig.SNS_USERINFO_URL, params, null, null);
    try {
      authUserInfo = JSONUtils.fromJsonString(result, AuthUserInfo.class);
    } catch (JsonSyntaxException e){
      logger.debug("transfer exception");
    }
    return authUserInfo;
  }

  /**
   * 校验授权凭证（access_token）是否有效
   * @param accessToken   网页授权接口调用凭证
   * @param openid        用户唯一标识
   * @return {"errcode": 0, "errmsg": "ok"} 成功   {"errcode": 40003, "errmsg": "invalid openid"}失败
   */
  @Override
  public ResultState authToken(String accessToken, String openid) {
    ResultState state = null;
    Map<String, String> params = new TreeMap<>();
    params.put("access_token", accessToken);
    params.put("openid", openid);
    String result = HttpReqUtils.HttpDefaultExecute(SystemConstant.GET_METHOD, WechatConfig.CHECK_SNS_AUTH_STATUS_URL, params, "", null);
    state = JSONUtils.fromJsonString(result, ResultState.class);
    return state;
  }

  /**
   * 获取jsapi_ticket调用微信JS接口的临时票据
   * @param accessToken
   * @return
   */
  @Override
  public String getTicket(String accessToken) {
    JsapiTicket ticket = null;
    Map<String, String> params = new TreeMap<>();
    params.put("access_token", accessToken);
    params.put("type", "jsapi");
    String result = HttpReqUtils.HttpDefaultExecute(SystemConstant.GET_METHOD, WechatConfig.GET_TICKET_URL, params, "", null);
    ticket = JSONUtils.fromJsonString(result, JsapiTicket.class);
    if (ticket.getErrcode() == 0) {
      return ticket.getTicket();
    }
    return null;
  }
}
