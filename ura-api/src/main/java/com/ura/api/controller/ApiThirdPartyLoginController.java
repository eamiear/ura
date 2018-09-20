/**
 * @author eamiear
 * @date 2018/9/19 17:11
 */

package com.ura.api.controller;

import com.ura.common.support.context.Resources;
import com.ura.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Api(tags = "第三方登录接口")
public class ApiThirdPartyLoginController {

    @GetMapping("/callback/wx")
    @ApiOperation(value = "微信登录回调")
    public R wxCallback(String code, String state, HttpServletRequest request){
      if (StringUtils.isNotBlank(code)){

      }
      return R.success();
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
