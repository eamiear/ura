/**
 * @author eamiear
 * @date 2018/12/6 14:58
 */

package com.ura.ai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.ura.ai.common.BaiduFactory;
import com.ura.ai.common.TencentFactory;
import com.ura.ai.pojo.baidu.bean.FaceMatch;
import com.ura.ai.pojo.tencent.bean.FaceCrossage;
import com.ura.common.utils.*;
import com.ura.taip.face.TAipFace;
import com.ura.taip.ptu.TAipPtu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("rest/ptu")
@Api(tags = "图片特效")
public class TencentPtuController {
  private static Logger logger = LoggerFactory.getLogger(TencentPtuController.class);
  private TAipFace tAipFace = TencentFactory.createTAipFace();
  private TAipPtu tAipPtu = TencentFactory.createTAipPtu();
  private AipFace aipFace = BaiduFactory.getAipFace();

  // 人脸融合
  @PostMapping("/face/merge/file")
  @ApiOperation("人脸融合")
  public R faceMerge(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file,
    @ApiParam("模型") Integer model) {
    R r = new R();
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "文件不能为空");
    }
    try {
      byte[] image = file.getBytes();
      String result = tAipPtu.faceMerge(image, model);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
      return r;
    } catch (Exception ex) {
      ex.printStackTrace();
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "接口异常");
    }
    return r;
  }

  @RequestMapping(value = "/face/merge/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("人脸融合")
  public R faceMerge(@ApiParam("图片url") String url, @ApiParam("模型") Integer model) {
    R r = new R();
    if (StringUtils.isBlank(url)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      String result = tAipPtu.faceMerge(image, model);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
      is.releaseConnection();
      is = null;
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  // 美妆
  @PostMapping("/face/cosmetic/file")
  @ApiOperation("美妆")
  public R faceCosmetic(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file,
    @ApiParam("美妆编码") Integer cosmetic) {
    R r = new R();
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "文件不能为空");
    }
    try {
      byte[] image = file.getBytes();
      String result = tAipPtu.faceCosmetic(image, cosmetic);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
    } catch (Exception e) {
      e.printStackTrace();
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  @RequestMapping(value = "/face/cosmetic/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("美妆")
  public R faceCosmetic(@ApiParam("图片url") String url, @ApiParam("美妆编码") Integer cosmetic) {
    R r = new R();
    if (StringUtils.isBlank(url)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      String result = tAipPtu.faceCosmetic(image, cosmetic);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
      is.releaseConnection();
      is = null;
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }
  // 变妆
  @PostMapping("/face/decoration/file")
  @ApiOperation("变妆")
  public R faceDecoration(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file,
    @ApiParam("变妆编码") Integer decoration) {
    R r = new R();
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "文件不能为空");
    }
    try {
      byte[] image = file.getBytes();
      String result = tAipPtu.faceDecoration(image, decoration);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
    } catch (Exception e) {
      e.printStackTrace();
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  @RequestMapping(value = "/face/decoration/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("变妆")
  public R faceDecoration(@ApiParam("图片url") String url, @ApiParam("变妆编码") Integer decoration) {
    R r = new R();
    if (StringUtils.isBlank(url)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      String result = tAipPtu.faceDecoration(image, decoration);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
      is.releaseConnection();
      is = null;
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }
  // 图片滤镜
  @PostMapping("/image/filter/file")
  @ApiOperation("图片滤镜")
  public R imageFilter(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file,
    @ApiParam("滤镜特效编码") Integer filter) {
    R r = new R();
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "文件不能为空");
    }
    try {
      byte[] image = file.getBytes();
      String result = tAipPtu.imgFilter(image, filter);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
    } catch (Exception e) {
      e.printStackTrace();
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  @RequestMapping(value = "/image/filter/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("图片滤镜")
  public R imageFilter(@ApiParam("图片url") String url, @ApiParam("滤镜特效编码") Integer filter) {
    R r = new R();
    if (StringUtils.isBlank(url)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      String result = tAipPtu.imgFilter(image, filter);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
      is.releaseConnection();
      is = null;
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }
  // 图片滤镜 ailab
  @PostMapping("/vision/filter/file")
  @ApiOperation("AILab图片滤镜")
  public R visionFilter(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file,
    @ApiParam("滤镜特效编码") Integer filter) {
    R r = new R();
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "文件不能为空");
    }
    try {
      byte[] image = file.getBytes();
      String result = tAipPtu.visionImgfilter(image, filter,String.valueOf(System.currentTimeMillis()));
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
    } catch (Exception e) {
      e.printStackTrace();
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  @RequestMapping(value = "/vision/filter/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("AILab图片滤镜")
  public R visionFilter(@ApiParam("图片url") String url, @ApiParam("滤镜特效编码") Integer filter) {
    R r = new R();
    if (StringUtils.isBlank(url)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      String result = tAipPtu.visionImgfilter(image, filter,String.valueOf(System.currentTimeMillis()));
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
      is.releaseConnection();
      is = null;
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  @PostMapping("/face/sticker/file")
  @ApiOperation("大头贴")
  public R faceSticker(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file,
    @ApiParam("大头贴编码") Integer sticker) {
    R r = new R();
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "文件不能为空");
    }
    try {
      byte[] image = file.getBytes();
      String result = tAipPtu.faceSticker(image, sticker);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
    } catch (Exception e) {
      e.printStackTrace();
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  @RequestMapping(value = "/face/sticker/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("大头贴")
  public R faceSticker(@ApiParam("图片url") String url, @ApiParam("大头贴编码") Integer sticker) {
    R r = new R();
    if (StringUtils.isBlank(url)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      String result = tAipPtu.faceSticker(image, sticker);
      JSONObject jsonObject = JSON.parseObject(result);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
      is.releaseConnection();
      is = null;
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  // 人脸对比|跨年龄对比
  @PostMapping("/face/cross/file")
  @ApiOperation("颜龄检测")
  public R faceDetectCrossage(@ApiParam("图片文件") @RequestParam(value = "files") MultipartFile[] files) {
    R r = new R();
    if (ArrayUtils.isEmpty(files) || (ArrayUtils.isNotEmpty(files) && files.length < 2)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "图片不能为空或不得少于两张图片");
    }
    try {
      MultipartFile faceOriginFile = files[0];
      MultipartFile faceTargetFile = files[1];
      List<MatchRequest> faceList = new ArrayList<MatchRequest>();
      MatchRequest faceOriginMatch = new MatchRequest(Base64Util.encode(faceOriginFile.getBytes()), "BASE64");
      MatchRequest faceTargetMatch = new MatchRequest(Base64Util.encode(faceTargetFile.getBytes()), "BASE64");
      faceList.add(faceOriginMatch);
      faceList.add(faceTargetMatch);
      String result = tAipFace.detectCrossage(faceOriginFile.getBytes(), faceTargetFile.getBytes());
      FaceCrossage faceCrossage = JSONObject.toJavaObject(JSON.parseObject(result), FaceCrossage.class);
      if (faceCrossage.getRet() != 0) {

      }
      DecimalFormat df = new DecimalFormat("#.00");
      FaceCrossage.Data faceCrossData = new FaceCrossage.Data();

      org.json.JSONObject jsonObject = aipFace.match(faceList);
      FaceMatch faceMatch = JSONObject.toJavaObject(JSON.parseObject(jsonObject.toString()), FaceMatch.class);
      if (faceMatch.getError_code() == 0 && faceMatch.getError_msg().equals("SUCCESS")) {
        double score = faceMatch.getResult().getScore();
        faceCrossData.setScores(df.format(score));
        if (score < 30) {
          faceCrossData.setInfo("同一个人的可能性极低");
        } else if (score > 30 && score < 60) {
          faceCrossData.setInfo("同一个人的可能性低");
        } else if (score > 60 && score < 80) {
          faceCrossData.setInfo("同一个人的可能性高");
        } else {
          faceCrossData.setInfo("同一个人的可能性极高");
        }
        double tscore = faceCrossage.getData().getScore() * 100;
        faceCrossData.setDegree(df.format(tscore));
        faceCrossage.setData(faceCrossData);
      } else {

      }
      r.put("msg", faceCrossage.getMsg()).put("data", JSONResult.build().put("detect", faceCrossage.getData()));
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  @RequestMapping(value = "/face/cross/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("颜龄检测")
  public R faceCrossage(@ApiParam("图片url") String url, @ApiParam("图片url") String url2) {
    R r = new R();
    if (StringUtils.isBlank(url) || StringUtils.isBlank(url2)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      GetMethod getUrl2 = HttpUtils.URLGet(url, new HashMap<>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      byte[] image2 = FileUtils.readStreamByBytes(getUrl2.getResponseBodyAsStream());
      List<MatchRequest> faceList = new ArrayList<MatchRequest>();
      MatchRequest faceOriginMatch = new MatchRequest(Base64Util.encode(image), "BASE64");
      MatchRequest faceTargetMatch = new MatchRequest(Base64Util.encode(image2), "BASE64");
      faceList.add(faceOriginMatch);
      faceList.add(faceTargetMatch);
      String result = tAipFace.detectCrossage(image, image2);
      FaceCrossage faceCrossage = JSONObject.toJavaObject(JSON.parseObject(result), FaceCrossage.class);
      DecimalFormat df = new DecimalFormat("#.00");
      FaceCrossage.Data faceCrossData = new FaceCrossage.Data();

      org.json.JSONObject jsonObject = aipFace.match(faceList);
      FaceMatch faceMatch = JSONObject.toJavaObject(JSON.parseObject(jsonObject.toString()), FaceMatch.class);
      if (faceMatch.getError_code() == 0 && faceMatch.getError_msg().equals("SUCCESS")) {
        double score = faceMatch.getResult().getScore();
        faceCrossData.setScores(df.format(score));
        if (score < 30) {
          faceCrossData.setInfo("同一个人的可能性极低");
        } else if (score > 30 && score < 60) {
          faceCrossData.setInfo("同一个人的可能性低");
        } else if (score > 60 && score < 80) {
          faceCrossData.setInfo("同一个人的可能性高");
        } else {
          faceCrossData.setInfo("同一个人的可能性极高");
        }
        double tscore = faceCrossage.getData().getScore() * 100;
        faceCrossData.setDegree(df.format(tscore));
        faceCrossage.setData(faceCrossData);
      }
      is.releaseConnection();
      getUrl2.releaseConnection();
      is = null;
      getUrl2 = null;
      r.put("msg", faceCrossage.getMsg()).put("data", JSONResult.build().put("detect", faceCrossage.getData()));
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }
}
