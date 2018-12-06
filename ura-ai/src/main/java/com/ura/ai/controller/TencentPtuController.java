/**
 * @author eamiear
 * @date 2018/12/6 14:58
 */

package com.ura.ai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.face.AipFace;
import com.ura.ai.common.BaiduFactory;
import com.ura.ai.common.TencentFactory;
import com.ura.common.utils.FileUtils;
import com.ura.common.utils.HttpUtils;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import com.ura.taip.face.TAipFace;
import com.ura.taip.ptu.TAipPtu;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("rest/ptu")
public class TencentPtuController {
  private static Logger logger = LoggerFactory.getLogger(TencentPtuController.class);
  TAipFace tAipFace = TencentFactory.createTAipFace();
  TAipPtu tAipPtu = TencentFactory.createTAipPtu();
  AipFace aipFace = BaiduFactory.getAipFace();

  // 人脸融合
  @RequestMapping("/face/merge/file")
  public R faceMerge(@RequestParam(value = "file")MultipartFile file, Integer model) {
    R r = new R();
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
  @RequestMapping("/face/merge/url")
  public R faceMerge(String url, Integer model) {
    R r = new R();
    if (null == url) {
      return R.error().put("msg", "请输入网络图片url");
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
  @RequestMapping("/face/cosmetic/file")
  public R faceCosmetic(@RequestParam(value = "file") MultipartFile file, Integer cosmetic) {
    R r = new R();
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
  @RequestMapping("/face/cosmetic/url")
  public R faceCosmetic(String url, Integer cosmetic) {
    R r = new R();
    if (null == url) {
      return R.error().put("msg", "请输入网络图片url");
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
  @RequestMapping("/face/decoration/file")
  public R faceDecoration(@RequestParam(value = "file") MultipartFile file, Integer decoration) {
    R r = new R();
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
  @RequestMapping("/face/decoration/url")
  public R faceDecoration(String url, Integer decoration) {
    R r = new R();
    if (null == url) {
      return R.error().put("msg", "请输入网络图片url");
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
  @RequestMapping("/image/filter/file")
  public R imageFilter(@RequestParam(value = "file") MultipartFile file, Integer filter) {
    R r = new R();
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
  @RequestMapping("/image/filter/url")
  public R imageFilter(String url, Integer filter) {
    R r = new R();
    if (null == url) {
      return R.error().put("msg", "请输入网络图片url");
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
  @RequestMapping("/vision/filter/file")
  public R visionFilter(@RequestParam(value = "file") MultipartFile file, Integer filter) {
    R r = new R();
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
  @RequestMapping("/vision/filter/url")
  public R visionFilter(String url, Integer filter) {
    R r = new R();
    if (null == url) {
      return R.error().put("msg", "请输入网络图片url");
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
}
