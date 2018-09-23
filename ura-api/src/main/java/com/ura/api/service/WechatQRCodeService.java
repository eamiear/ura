package com.ura.api.service;

import com.ura.wechat.model.result.WechatResult;

public interface WechatQRCodeService {
  /**
   * 创建临时带参二维码
   * @param accessToken
   * @param expireSeconds 二维码有效时间，单位秒。不超过30天，默认30秒
   * @param sceneId       场景Id
   * @return
   */
  public String createTempTicket(String accessToken, int expireSeconds, int sceneId);

  /**
   * 创建永久二维码（数字）
   * @param accessToken
   * @param sceneId 场景id
   * @return
   */
  public String createForeverTicket(String accessToken, int sceneId);

  /**
   * 创建永久二维码（字符串）
   * @param accessToken
   * @param sceneStr   场景字符串
   * @return
   */
  public String createForeverTicket(String accessToken, String sceneStr);

  /**
   * 通过ticket获取二维码图片
   * @param accessToken
   * @param ticket
   * @return 二维码地址
   * @throws Exception
   */
  public String showQrcode(String accessToken, String ticket) throws Exception;

  /**
   * 下载二维码
   * @param ticket
   * @param savePath 保存路径
   * @return
   * @throws Exception
   */
  public WechatResult downloadQrcode(String ticket, String savePath) throws Exception;
}
