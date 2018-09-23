package com.ura.api.controller;

import com.ura.api.service.WechatAuthService;
import com.ura.common.config.WechatConfig;
import com.ura.common.utils.JSONResult;
import com.ura.common.utils.R;
import com.ura.api.service.WechatQRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/wx")
public class ApiQRCodeController {
  @Autowired
  private WechatQRCodeService wechatQRCodeService;

  @Autowired
  private WechatAuthService wechatAuthService;

  @GetMapping("qr/ticket")
  public R createTempTicket(int sceneId){
    String accessToken = wechatAuthService.getAccessToken(WechatConfig.APP_ID, WechatConfig.APP_SECRET);
    R r = new R();
    try {
      String ticket = wechatQRCodeService.createTempTicket(accessToken, 2592000, sceneId);
      String url = wechatQRCodeService.showQrcode(accessToken, ticket);
      r.put("code", 0).put("data", JSONResult.build().put("ticket", ticket).put("url", url));
    } catch (Exception e){
      e.printStackTrace();
      r.put("code", -1);
    }
    return r;
  }
}
