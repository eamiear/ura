/**
 * @author eamiear
 * @date 2018/11/29 11:43
 * 百度人脸识别
 */

package com.ura.ai.controller;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;
import com.ura.ai.pojo.baidu.bean.FaceDetect;
import com.ura.ai.pojo.baidu.resp.FaceDetectResp;
import com.ura.ai.common.BaiduFactory;
import com.ura.ai.entity.FaceDetectEntity;
import com.ura.ai.service.BaiduFaceDetectService;
import com.ura.common.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("rest/face")
@Api(tags = "人脸检测")
public class BaiduFaceController {
  private AipFace aipFace = BaiduFactory.getAipFace();

  @Autowired
  private BaiduFaceDetectService baiduFaceDetectService;

  @PostMapping("/detect")
  @ApiOperation("人脸检测，图片文件")
  public R detect(
    @ApiParam("人脸图片文件") @RequestParam(value = "file") MultipartFile file, String openId, String nickName, HttpServletRequest request) {
    R r = new R();
    if (file == null) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "图片不能为空");
    }
    try {
//        String prefix = "face/";
//        String fileName = "baidu-face-" + new Date().getTime() / 1000 + FileUtils.getExtend(file.getOriginalFilename());
//        String filePath = request.getSession().getServletContext().getRealPath(prefix);
//        FileUtils.uploadFile(file.getBytes(), filePath, fileName);
//        String imagePath = filePath + fileName;
//        String base64 = Base64Util.encode(FileUtils.readFileByBytes(imagePath));
      byte[] image = file.getBytes();
      String base64 = Base64Util.encode(image);
      JSONResult jsonResult = handleDetection(openId, nickName, base64, "BASE64", "");

      if (jsonResult != null) {
        r.put("msg", "检测成功").put("data", jsonResult);
      } else {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_ERROR).put("msg", "检测失败");
      }
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "第三方接口异常");
    }
    return r;
  }

  @RequestMapping(value = "/detect/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("人脸检测，图片url")
  public R detect(@ApiParam("图片url") String url, String openId, String nickName) {
    R r = new R();
    if (url == null) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "图片地址不能为空");
    }

    try {
      JSONResult jsonResult = handleDetection(openId, nickName, url, "URL", "");
      if (jsonResult != null) {
        r.put("msg", "检测成功").put("data", jsonResult);
      } else {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_ERROR).put("msg", "检测失败");
      }
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "第三方接口异常");
    }
    return r;
  }

  private JSONResult handleDetection(String openId, String nickName, String image, String imageType, String filePath) {
    // 返回到客户端
    FaceDetectResp faceDetectRespBean = null;

    HashMap<String, String> option = new HashMap<String, String>();
    option.put("face_field", "age,beauty,expression,faceshape,gender,glasses,race,quality,landmark,angle,location");
    option.put("max_face_num", "1");
    JSONObject jsonObject = aipFace.detect(image, imageType, option);
    FaceDetect faceDetect = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), FaceDetect.class);

    if (null != faceDetect.getResult()) {
      FaceDetectEntity faceDetectEntity;
      faceDetectEntity = getFaceDetectEntity(faceDetect, filePath);
      faceDetectEntity.setOpenId(openId);
      faceDetectEntity.setNickName(nickName);
//        FaceDetectEntity faceEntity = baiduFaceDetectService.getFaceByFaceToken(faceDetect.getResult().getFace_list().get(0).getFace_token());
//        if (faceEntity == null) {
//          boolean result = baiduFaceDetectService.save(faceDetectEntity);
//        }
      faceDetectRespBean = new FaceDetectResp();
      faceDetectRespBean.setAge(faceDetectEntity.getAge());
      faceDetectRespBean.setBeauty(faceDetectEntity.getBeauty());
      faceDetectRespBean.setExpression(getExpression(faceDetectEntity.getExpressionType()));
      faceDetectRespBean.setGender(getGender(faceDetectEntity.getGender()));
      faceDetectRespBean.setGlasses(getGlasses(faceDetectEntity.getGlassesType()));
      faceDetectRespBean.setRaceType(getRaceType(faceDetectEntity.getRaceType()));
      faceDetectRespBean.setFaceShape(getFaceShape(faceDetectEntity.getFaceShapeType()));
    }
    return JSONResult.build().put("detect", faceDetectRespBean).put("raw", faceDetect);
  }

  @PostMapping("/compare")
  public R compare() {
    return R.success();
  }

  private String getRaceType(String type) {
    String result;
    switch (type) {
      case "yellow":
        result = "黄种人";
        break;
      case "white":
        result = "黄种人";
        break;
      case "black":
        result = "黑种人";
        break;
      case "arabs":
        result = "阿拉伯人";
        break;
      default:
        result = "未知";
    }

    return result;
  }

  private String getFaceShape(String type) {
    String result;
    switch (type) {
      case "square":
        result = "正方形";
        break;
      case "triangle":
        result = "三角形";
        break;
      case "oval":
        result = "椭圆";
        break;
      case "heart":
        result = "心形";
        break;
      case "round":
        result = "圆形";
        break;
      default:
        result = "未知";
    }
    return result;
  }

  private String getGlasses(String type) {
    String result;
    switch (type) {
      case "none":
        result = "无眼镜";
        break;
      case "common":
        result = "普通眼镜";
        break;
      case "sun":
        result = "墨镜";
        break;
      default:
        result = "未知";
    }

    return result;
  }

  private String getGender(String type) {
    String result;
    switch (type) {
      case "male":
        result = "男性";
        break;
      case "female":
        result = "女性";
        break;
      default:
        result = "未知";
    }
    return result;
  }

  private String getExpression(String type) {
    String result;
    switch (type) {
      case "none":
        result = "不笑";
        break;
      case "smile":
        result = "微笑";
        break;
      case "laugh":
        result = "大笑";
        break;
      default:
        result = "未知";
    }
    return result;
  }

  private FaceDetectEntity getFaceDetectEntity(FaceDetect faceDetectBean, String imagePath) {
    FaceDetectEntity faceDetect = new FaceDetectEntity();
    faceDetect.setErrorCode(String.valueOf(faceDetectBean.getError_code()));
    faceDetect.setErrorMsg(faceDetectBean.getError_msg());
    faceDetect.setLogId(String.valueOf(faceDetectBean.getLog_id()));
    faceDetect.setTimestamp(String.valueOf(faceDetectBean.getTimestamp()));
    faceDetect.setCached(faceDetectBean.getCached());
    faceDetect.setFaceNum(faceDetectBean.getResult().getFace_num());
    faceDetect.setFaceToken(faceDetectBean.getResult().getFace_list().get(0).getFace_token());
    faceDetect.setFaceProbability(String.valueOf(faceDetectBean.getResult().getFace_list().get(0).getFace_probability()));
    faceDetect.setAge(faceDetectBean.getResult().getFace_list().get(0).getAge());
    faceDetect.setBeauty(String.valueOf(faceDetectBean.getResult().getFace_list().get(0).getBeauty()));
    faceDetect.setExpressionType(faceDetectBean.getResult().getFace_list().get(0).getExpression().getType());
    faceDetect.setFaceShapeType(faceDetectBean.getResult().getFace_list().get(0).getFace_shape().getType());
    faceDetect.setGender(faceDetectBean.getResult().getFace_list().get(0).getGender().getType());
    faceDetect.setGlassesType(faceDetectBean.getResult().getFace_list().get(0).getGlasses().getType());
    faceDetect.setRaceType(faceDetectBean.getResult().getFace_list().get(0).getRace().getType());
    faceDetect.setImagePath(imagePath);
    return faceDetect;
  }
}
