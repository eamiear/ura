package com.ura.api.service;

import com.ura.wechat.model.base.AbstractParams;
import com.ura.wechat.model.resp.AuthAccessToken;
import com.ura.wechat.model.resp.AuthUserInfo;
import com.ura.wechat.model.resp.ResultState;

public interface WechatAuthService {
  /**
   * 获取授权请求url
   * @param params
   * @param url
   * @return
   * @throws Exception
   */
  public String getAuthPath(AbstractParams params, String url) throws Exception;

  /**
   * 获取网页授权凭证
   * @param params
   * @param url
   * @return
   */
  public AuthAccessToken getAuthAccessToken(AbstractParams params, String url);

  /**
   * 刷新网页授权验证
   * @param params  参数
   * @param url
   * @return
   */
  public AuthAccessToken refreshAuthAccessToken(AbstractParams params, String url);

  /**
   * 通过网页授权获取用户信息
   * @param accessToken
   * @param openid
   * @return
   */
  public AuthUserInfo getAuthUserInfo(String accessToken, String openid);

  /**
   * 校验授权凭证（access_token）是否有效
   * @param accessToken   网页授权接口调用凭证
   * @param openid        用户唯一标识
   * @return {"errcode": 0, "errmsg": "ok"} 成功   {"errcode": 40003, "errmsg": "invalid openid"}失败
   */
  public ResultState authToken(String accessToken, String openid);

  /**
   * 获取jsapi_ticket 调用微信JS接口的临时票据
   * @param accessToken
   * @return
   */
  public String getTicket(String accessToken);
}
