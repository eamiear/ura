package com.ura.api.controller;

import com.ura.common.base.BaseController;
import com.ura.common.config.WechatConfig;
import com.ura.common.utils.IPUtils;
import com.ura.common.utils.PayUtils;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import com.ura.wechat.constants.PayConstant;
import com.ura.wechat.model.req.UnifiedOrderParams;
import com.ura.wechat.model.resp.JsPayResult;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wx/pay")
@Api(tags = "微信支付接口")
public class ApiWechatPayController extends BaseController{
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public R jsPay(@ModelAttribute(value = "params")UnifiedOrderParams params){
    JsPayResult result = null;
    if (StringUtils.isEmpty(params) || StringUtils.isEmpty(params.getOpenid())){
      return R.error(StatusCodeConstant.PARAM_NOT_EMPTY, "支付数据错误");
    }
    // 单号
    String out_trade_no = PayUtils.createOutTradeNo();
    String spbill_create_ip = IPUtils.getIp(this.getRequest());
    String nonce_str = PayUtils.createNonceStr();

    UnifiedOrderParams unifiedOrderParams = new UnifiedOrderParams();
    unifiedOrderParams.setAppid(WechatConfig.APP_ID);
    unifiedOrderParams.setMch_id(PayConstant.MCH_ID);
    unifiedOrderParams.setOut_trade_no(out_trade_no);
    unifiedOrderParams.setBody(params.getBody());
    unifiedOrderParams.setTotal_fee(params.getTotal_fee());
    unifiedOrderParams.setNonce_str(nonce_str);
    unifiedOrderParams.setSpbill_create_ip(spbill_create_ip);
    unifiedOrderParams.setTrade_type("JSAPI");
    unifiedOrderParams.setOpenid(params.getOpenid());
    unifiedOrderParams.setNotify_url(WechatConfig.NOTIFY_URL);



  }
}
