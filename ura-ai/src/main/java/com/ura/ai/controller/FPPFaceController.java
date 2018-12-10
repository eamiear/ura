/**
 * @author eamiear
 * @date 2018/12/10 10:19
 */

package com.ura.ai.controller;

import com.alibaba.fastjson.JSON;
import com.ura.ai.pojo.fpp.bean.FPPSkinBean;
import com.ura.ai.pojo.fpp.resp.FPPFaceDetectResp;
import com.ura.common.constant.AIConstant;
import com.ura.common.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/rest/fpp")
@Api(tags = "face++ 接口")
public class FPPFaceController {
  @PostMapping("/detect/file")
  @ApiOperation("肤质检测")
  public R detect(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file) {
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "文件不能为空");
    }
    try {
      Map<String, Object> params = getParams(file.getBytes());
      String result = HttpUtils.URLPost(AIConstant.FPP_FACE_DETECT_URL, params, "utf-8");
      FPPSkinBean skinBean = JSON.parseObject(result, FPPSkinBean.class);
      return handleFppFaceDetectResponse(skinBean);
    } catch (Exception e) {
      e.printStackTrace();
      return R.error().put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "接口异常");
    }
  }

  @RequestMapping(value = "/detect/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("肤质检测")
  public R detect(@ApiParam("图片url") String url) {
    if (StringUtils.isBlank(url)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      Map<String, Object> params = getParams(image);
      String result = HttpUtils.URLPost(AIConstant.FPP_FACE_DETECT_URL, params, "utf-8");
      FPPSkinBean skinBean = JSON.parseObject(result, FPPSkinBean.class);
      return handleFppFaceDetectResponse(skinBean);
    } catch (Exception e) {
      e.printStackTrace();
      return R.error().put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "接口异常");
    }
  }

  private R handleFppFaceDetectResponse(FPPSkinBean skinBean) {
    if (Objects.isNull(skinBean)) {
      return R.error().put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "无效识别");
    } else {
      if (skinBean.getFaces().size() <= 0) {
        return R.error().put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", "无效识别");
      } else {
        FPPFaceDetectResp detectResp = new FPPFaceDetectResp();
        FPPSkinBean.Skinstatus skinstatus = skinBean.getFaces().get(0).getAttributes().getSkinstatus();
        BigDecimal health = new BigDecimal(skinstatus.getHealth());
        BigDecimal stain = new BigDecimal(skinstatus.getStain());
        BigDecimal acne = new BigDecimal(skinstatus.getAcne());
        BigDecimal darkCircle = new BigDecimal(skinstatus.getDark_circle());
        detectResp.setHealth(health.toString());
        detectResp.setStain(stain.toString());
        detectResp.setAcne(acne.toString());
        detectResp.setDarkCircle(darkCircle.toString());
        return R.success().put("data", JSONResult.build().put("detect", detectResp).put("raw", skinBean));
      }
    }
  }

  private Map<String, Object> getParams(byte[] image) throws Exception {
    Base64.Encoder base64Encoder = Base64.getEncoder();
    String imageBase64 = base64Encoder.encodeToString(image);
    String return_attributes = "gender,age,smiling,headpose,facequality,blur,eyestatus,emotion,ethnicity,beauty,mouthstatus,eyegaze,skinstatus";
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("api_key", AIConstant.FPP_API_KEY);
    params.put("api_secret", AIConstant.FPP_API_SECRET);
    params.put("image_base64", URLEncoder.encode(imageBase64, "utf-8"));
    params.put("return_attributes", return_attributes);
    return params;
  }
}
