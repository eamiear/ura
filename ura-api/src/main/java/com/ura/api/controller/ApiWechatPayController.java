package com.ura.api.controller;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.common.base.BaseController;
import com.ura.common.config.WechatConfig;
import com.ura.common.constant.SystemConstant;
import com.ura.common.utils.IPUtils;
import com.ura.wechat.model.req.PayShortUrlParams;
import com.ura.wechat.model.resp.PayShortUrlResult;
import com.ura.wechat.model.resp.UnifiedOrderResult;
import com.ura.wechat.utils.*;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import com.ura.wechat.constants.PayConstant;
import com.ura.wechat.model.req.UnifiedOrderParams;
import com.ura.wechat.model.resp.JsPayResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Objects;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/wx/pay")
@Api(tags = "微信支付接口")
public class ApiWechatPayController extends BaseController{
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 微信内H5调起支付
   * @param params
   * @return
   */
  @IgnoreAuth
  @PostMapping("/js")
  @ApiOperation("微信内H5支付")
  public R jsPay(@ModelAttribute(value = "params") UnifiedOrderParams params){
    R r = new R();
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

    // 统一下单 请求的Xml(正常的xml格式)
    String unifiedXml = MsgUtils.abstractPayToXml(unifiedOrderParams);
    // 返回<![CDATA[SUCCESS]]>格式的XML
    String unifiedOrderResultXml = HttpReqUtils.HttpDefaultExecute(SystemConstant.POST_METHOD, WechatConfig.UNIFIED_ORDER_URL, null, unifiedXml, null);

    try {
      if (SignatureUtils.checkIsSignValidFromWeiXin(unifiedOrderResultXml, null, null)){
        String timeStamp = PayUtils.createTimeStamp();
        UnifiedOrderResult unifiedOrderResult = XmlUtils.getObjectFromXML(unifiedOrderResultXml, UnifiedOrderResult.class);
        result = new JsPayResult();
        result.setAppId(WechatConfig.APP_ID);
        result.setTimeStamp(timeStamp);
        result.setNonceStr(unifiedOrderResult.getNonce_str());
        /** prepay_id 2小时内都有效，再次支付方法自己重写 ****/
        result.setPackageStr("prepay_id=" + unifiedOrderResult.getPrepay_id());
        String paySign = SignatureUtils.createSign(result, PayConstant.API_KEY, SystemConstant.DEFAULT_CHARACTER_ENCODING);
        result.setPaySign(paySign);
        result.setResultCode(unifiedOrderResult.getResult_code());

        r.put("code", StatusCodeConstant.BUSINESS_PAY_SUCCESS).put("msg", "支付成功").put("data", result);
      } else {
        r.put("code", StatusCodeConstant.BUSINESS_PAY_ERROR).put("msg", "支付失败");
        logger.debug("签名验证失败");
      }
    } catch (ParserConfigurationException | IOException |SAXException e){
      r.put("code", StatusCodeConstant.BUSINESS_PAY_ERROR).put("msg", "支付失败");
      logger.debug(e.getMessage());
    }
    return r;
  }

  /**
   * 扫码支付模式   生成二维码
   * @param productId  商品ID
   * @return
   */
  @IgnoreAuth
  @GetMapping("/qrcode")
  @ApiOperation("生成扫码支付二维码")
  public R scanPay(String productId){
    R r = new R();
    String nonce_str = PayUtils.createNonceStr();
    TreeMap<String, Object> packageParams = new TreeMap<>();
    packageParams.put("appid", WechatConfig.APP_ID);
    packageParams.put("mch_id", PayConstant.MCH_ID);
    packageParams.put("product_id", productId);
    packageParams.put("time_stamp", PayUtils.createTimeStamp());
    packageParams.put("nonce_str", nonce_str);
    String str_url = PayUtils.createPayImageUrl(packageParams);
    String sign = SignatureUtils.createSign(packageParams, PayConstant.API_KEY, SystemConstant.DEFAULT_CHARACTER_ENCODING);
    packageParams.put("sign", sign);
    String payUrl = PayConstant.PAY_URL + sign + str_url;
    logger.debug("payurl is {}", payUrl);

    // 转成短连接
    PayShortUrlParams payShortUrlParams = new PayShortUrlParams();
    payShortUrlParams.setAppid(WechatConfig.APP_ID);
    payShortUrlParams.setMch_id(PayConstant.MCH_ID);
    payShortUrlParams.setLong_url(payUrl);
    payShortUrlParams.setNonce_str(nonce_str);
    String urlSign = SignatureUtils.createSign(payShortUrlParams, PayConstant.API_KEY, SystemConstant.DEFAULT_CHARACTER_ENCODING);
    payShortUrlParams.setSign(urlSign);
    String longXml = XmlUtils.toSplitXml(payShortUrlParams);
    String shortResult = HttpReqUtils.HttpsDefaultExecute(SystemConstant.POST_METHOD, WechatConfig.PAY_SHORT_URL, null, longXml, null);
    PayShortUrlResult payShortUrlResult = XmlUtils.getObjectFromXML(shortResult, PayShortUrlResult.class);
    if (Objects.equals("SUCCESS", payShortUrlResult.getReturn_code())){
      payUrl = payShortUrlResult.getShort_url();
    } else {
      logger.debug("错误信息" + payShortUrlResult.getReturn_msg());
    }
    // TODO 生成二维码
    return r;
  }
}
