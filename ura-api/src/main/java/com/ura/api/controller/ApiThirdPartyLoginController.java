/**
 * @author eamiear
 * @date 2018/9/19 17:11
 */

package com.ura.api.controller;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.api.entity.TokenEntity;
import com.ura.api.entity.UserEntity;
import com.ura.api.service.TokenService;
import com.ura.api.service.UserService;
import com.ura.api.service.WechatAuthService;
import com.ura.common.config.WechatConfig;
import com.ura.common.support.context.Resources;
import com.ura.common.utils.*;
import com.ura.wechat.model.req.AuthCodeParams;
import com.ura.wechat.model.req.AuthTokenParams;
import com.ura.wechat.model.resp.AuthAccessToken;
import com.ura.wechat.model.resp.AuthUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.Date;

@RestController
@RequestMapping("/api")
@Api(tags = "第三方登录接口")
public class ApiThirdPartyLoginController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private WechatAuthService wechatAuthService;

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UserService userService;

    @IgnoreAuth
    @GetMapping("/auth/cb")
    public R code(@RequestParam("code") String code, @RequestParam("state") String state, HttpServletRequest request){
      if (StringUtils.isEmpty(code)){
        return R.error(StatusCodeConstant.TOKEN_OAUTH_ERROR, "授权失败");
      }
      UserEntity userEntity = null;
      try {
        AuthTokenParams authToken = new AuthTokenParams();
        authToken.setAppid(WechatConfig.APP_ID);
        authToken.setSecret(WechatConfig.APP_SECRET);
        authToken.setCode(code);
        AuthAccessToken accessToken = wechatAuthService.getAuthAccessToken(authToken, WechatConfig.GET_OAUTH_TOKEN_URL);
        AuthUserInfo userInfo = wechatAuthService.getAuthUserInfo(accessToken.getAccess_token(), accessToken.getOpenid());
        userEntity = userService.queryByOpenId(userInfo.getOpenid());
        if (userEntity != null) {
          userEntity.setLoginTimes(userEntity.getLoginTimes() + 1);
          userEntity.setLastLgoinIp(IPUtils.getIp(request));
          userEntity.setLastLoginTime(new Date());
        } else {
          userEntity = new UserEntity();
          userEntity.setUsername(userInfo.getNickname());
          userEntity.setAvatar(userInfo.getHeadimageurl());
          userEntity.setGender(Integer.valueOf(userInfo.getSex()));
          userEntity.setNickname(userInfo.getNickname());
          userEntity.setWeixinOpenid(userInfo.getOpenid());
          userEntity.setCountry(userInfo.getCountry());
          userEntity.setProvince(userInfo.getProvince());
          userEntity.setCity(userInfo.getCity());
          userEntity.setLoginTimes(0);
          userEntity.setRegisterTime(new Date());
          userEntity.setLastLoginTime(new Date());
          userEntity.setRegisterIp(IPUtils.getIp(request));
          userEntity.setLastLgoinIp(IPUtils.getIp(request));
        }
        boolean status = userService.insertOrUpdate(userEntity);
        if (!status) {
          return R.error(StatusCodeConstant.DATA_CREATE_ERROR, "微信用户创建失败");
        }
        userEntity = userService.queryByOpenId(userInfo.getOpenid());
        TokenEntity token = tokenService.createToken(userEntity.getUserId());
        return R.success().put("data", JSONResult.build().put("token", token.getToken()).put("expire", token.getExpireTime().getTime() - System.currentTimeMillis()));
      } catch (Exception e){
        logger.error("Error " + e.getMessage());
        return R.error(StatusCodeConstant.TOKEN_OAUTH_ERROR, "授权失败");
      }
    }

    @IgnoreAuth
    @GetMapping("auth/login/url")
    @ApiOperation("获取授权url")
    public String oauthLoginUrl(@ApiParam("授权重定向uri") @RequestParam(value = "redirect_uri", required = false) String redirect_uri, HttpServletRequest request) throws Exception{
      if (StringUtils.isEmpty(redirect_uri)){
        redirect_uri = "";
        URL url = new URL(request.getRequestURL().toString());
        redirect_uri += url.getProtocol() + "://";
        redirect_uri += url.getHost();
        if (url.getPort() != -1){
          redirect_uri += ":" + url.getPort();
        }
        redirect_uri += "/ura/api/auth/cb";
        logger.info("path " + redirect_uri);
      }
      return oauthUrl(redirect_uri);
    }

    private String oauthUrl(String redirect_uri) throws Exception{
      AuthCodeParams authCodeParams = new AuthCodeParams();
      authCodeParams.setRedirect_uri(redirect_uri);
      authCodeParams.setAppid(WechatConfig.APP_ID);
      authCodeParams.setScope(AuthCodeParams.SCOPE_SNSAPIUSERINFO);
      authCodeParams.setState(MD5Utils.MD5Encode(WechatConfig.WECHAT_STATE, ""));
      return wechatAuthService.getAuthPath(authCodeParams, WechatConfig.AUTHORIZE_OAUTH_URL);
    }

    public String getRedirectUrl(HttpServletRequest request, String type){
      String AUTHORIZE_URL = "";
      String host = request.getHeader("host");
      AUTHORIZE_URL = Resources.THIRDPARTY.getString("AUTHORIZE_URL_" + type.toUpperCase());
      if ("wx".equalsIgnoreCase(type)){
        AUTHORIZE_URL += "?appid=%s&redirect_uri=%s&scope=%s&response_type=code&state=uraworld#wechat_redirect";
        String appId = Resources.THIRDPARTY.getString("APP_ID_" + type.toUpperCase());
        String redirectUrl = "http://" + request.getHeader("host") + Resources.THIRDPARTY.getString("REDIRECT_URL_" + type.toUpperCase());
        String scope = Resources.THIRDPARTY.getString("SCOPE_" + type.toUpperCase());
        AUTHORIZE_URL = String.format(AUTHORIZE_URL, appId, redirectUrl, scope);
      } else {
        AUTHORIZE_URL += "?client_id=%s&redirect_uri=%s&scope=%s&response_type=code";
        String clientId = Resources.THIRDPARTY.getString("APP_ID_" + type.toUpperCase());
        String redirectUrl = "http://" + request.getHeader("host") + Resources.THIRDPARTY.getString("REDIRECT_URL_" + type.toUpperCase());
        String scope = Resources.THIRDPARTY.getString("SCOPE_" + type.toUpperCase());
        AUTHORIZE_URL = String.format(AUTHORIZE_URL, clientId, redirectUrl, scope);
      }
      return AUTHORIZE_URL;
    }
}
