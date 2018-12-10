/**
 * @author eamiear
 * @date 2018/12/10 11:23
 */

package com.ura.ai.controller;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.util.Base64Util;
import com.ura.ai.common.HandTrackEnum;
import com.ura.ai.pojo.youtu.bean.HandTrackingBean;
import com.ura.ai.pojo.youtu.bean.HandWritingBean;
import com.ura.ai.pojo.youtu.bean.YouTuFaceBean;
import com.ura.ai.pojo.youtu.resp.YoutuFuseResp;
import com.ura.ai.utils.youtu.HttpUtils;
import com.ura.ai.utils.youtu.YouTuSign;
import com.ura.common.constant.AIConstant;
import com.ura.common.utils.FileUtils;
import com.ura.common.utils.JSONResult;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping(value = "rest/youtu")
@Api(tags = "优图接口")
public class YouTuController {
  @PostMapping("/detect/file")
  @ApiOperation("识别")
  public R detect(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file,
    @ApiParam("检测类型") Integer ocrType) {
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "文件不能为空");
    }
    try {
      JSONResult jsonResult = getYoutuResult(ocrType, file.getBytes());
      if (Objects.isNull(jsonResult.get("detect"))) {
        return R.error().put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", "无效识别");
      }
      return R.success().put("data", jsonResult);
    } catch (Exception e) {
      e.printStackTrace();
      return R.error().put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "接口异常");
    }
  }

  @RequestMapping(value = "/detect/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("识别")
  public R detect(@ApiParam("图片url") String url,
                  @ApiParam("检测类型") Integer ocrType) {
    if (StringUtils.isBlank(url)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = com.ura.common.utils.HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      JSONResult jsonResult = getYoutuResult(ocrType, image);
      if (Objects.isNull(jsonResult.get("detect"))) {
        return R.error().put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", "无效识别");
      }
      return R.success().put("data", jsonResult);
    } catch (Exception e) {
      e.printStackTrace();
      return R.error().put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "接口异常");
    }
  }

  private JSONResult getYoutuResult(Integer apiType, byte[] image) throws Exception {
    String jsonResult = "";
    JSONResult resultResp = JSONResult.build();
    String imageStr = Base64Util.encode(image);
    String params = "{\"app_id\":\"" + AIConstant.YOUTU_APPID + "\",\"image\":\"" + imageStr + "\"}";
    String sign = YouTuSign.getSign(AIConstant.YOUTU_USER_QQ, AIConstant.YOUTU_APPID, AIConstant.YOUTU_SECRETID, AIConstant.YOUTU_SECRET_KEY);
    YoutuFuseResp youtuFuseResp = null;

    if (AIConstant.YouTuType.HANDWRITING.getValue() == apiType) {
      jsonResult = HttpUtils.post(AIConstant.YT_OCR_HANDWRITING, params, sign);
      if (StringUtils.isNotEmpty(jsonResult)) {
        youtuFuseResp = new YoutuFuseResp();
        HandWritingBean handWritingBean = JSON.parseObject(jsonResult, HandWritingBean.class);
        String label = "";
        for (int i = 0; i < handWritingBean.getItems().size(); i++) {
          label += handWritingBean.getItems().get(i).getItemstring() + ",";
        }
        youtuFuseResp.setLabel(label);
        resultResp.put("raw", handWritingBean);
      }
      resultResp.put("detect", youtuFuseResp);
    } else if (AIConstant.YouTuType.HANDTRACKING.getValue() == apiType) {
      jsonResult = HttpUtils.post(AIConstant.YT_CLASSIFY_HANDTRACKING, params, sign);
      if (StringUtils.isNotEmpty(jsonResult)) {
        youtuFuseResp = new YoutuFuseResp();
        HandTrackingBean handTrackingBean = JSON.parseObject(jsonResult, HandTrackingBean.class);
        String label = "";
        String confidence = "";
        for (int i = 0; i < handTrackingBean.getItems().size(); i++) {
          label += HandTrackEnum.getLabelName(handTrackingBean.getItems().get(i).getLabel()) + ",";
          confidence += handTrackingBean.getItems().get(i).getConfidence() + "%,";
        }
        youtuFuseResp.setLabel(label.substring(0, label.length() - 1));
        youtuFuseResp.setConfidence(confidence.substring(0, confidence.length() - 1));
        youtuFuseResp.setClassifyCnt(handTrackingBean.getClassify_cnt());
        resultResp.put("raw", handTrackingBean);
      }
      resultResp.put("detect", youtuFuseResp);
    } else if (AIConstant.YouTuType.FACEDETECT.getValue() == apiType) {
      jsonResult = HttpUtils.post(AIConstant.YT_FACEDETECT, params, sign);
      if (StringUtils.isNotEmpty(jsonResult)) {
        youtuFuseResp = new YoutuFuseResp();
        YouTuFaceBean faceBean = JSON.parseObject(jsonResult, YouTuFaceBean.class);
        youtuFuseResp.setAge(String.valueOf(faceBean.getFace().get(0).getAge()));
        youtuFuseResp.setGlasses(getGlasses(faceBean.getFace().get(0).getGlasses()));
        youtuFuseResp.setExpression(getExpression(faceBean.getFace().get(0).getExpression()));
        youtuFuseResp.setBeauty(String.valueOf(faceBean.getFace().get(0).getBeauty()));
        resultResp.put("raw", faceBean);
      }
      resultResp.put("detect", youtuFuseResp);
    } else {
      resultResp.put("detect", null);
    }
    return resultResp;
  }

  /**
   * 获取眼睛中文说明
   *
   * @param glasses 眼镜[0不戴眼镜 1戴眼镜 2戴墨镜]
   * @return
   */
  private String getGlasses(int glasses) {
    if (glasses == 0) {
      return "不戴眼镜";
    } else if (glasses == 1) {
      return "戴眼镜";
    } else if (glasses == 2) {
      return "戴墨镜";
    } else {
      return "未知";
    }
  }

  /**
   * 获取表情中文说明
   *
   * @param expression 微笑[0(normal)~50(smile)~100(laugh)]
   * @return
   */
  private String getExpression(int expression) {
    if (expression < 50) {
      return "无表情";
    } else if (expression < 99) {
      return "微笑";
    } else {
      return "大笑";
    }
  }
}
