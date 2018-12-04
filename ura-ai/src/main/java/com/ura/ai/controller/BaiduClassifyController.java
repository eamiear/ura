/**
 * @author eamiear
 * @date 2018/11/29 15:47
 * 百度图像识别
 */

package com.ura.ai.controller;

import com.ura.ai.pojo.baidu.bean.GeneralDetect;
import com.ura.ai.pojo.baidu.bean.ResultBean;
import com.ura.ai.pojo.baidu.resp.*;
import com.ura.ai.common.BaiduFactory;
import com.ura.ai.common.UraAipImageClassify;
import com.ura.ai.entity.DishDetectEntity;
import com.ura.ai.entity.GeneralDetectEntity;
import com.ura.common.utils.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.HashMap;

@RestController
@RequestMapping("bd/icr")
public class BaiduClassifyController {

    private UraAipImageClassify uraAipImageClassify = BaiduFactory.getUraAipImageClassify();

    /**
     * 图像识别
     */
    @RequestMapping("/file")
    public R general(@RequestParam(value = "file")MultipartFile file, String detectType, String openId, String nickName, HttpServletRequest request){
      R r = new R();
      if (file == null) {
        return R.error().put("msg", "图片不能为空");
      }
      try {
//        String prefix = getPrefix(detectType);
//        String fileName = "baidu-ic-" + new Date().getTime() / 1000 + FileUtils.getExtend(file.getOriginalFilename());
//        String filePath = request.getSession().getServletContext().getRealPath(prefix);
//        FileUtils.uploadFile(file.getBytes(), filePath, fileName);
//        String imagePath = filePath + fileName;
//        byte[] image = FileUtils.readFileByBytes(imagePath);
        byte[] image = file.getBytes();
        JSONResult jsonResult = handleDetect(detectType, openId, nickName, image, "");
        if (jsonResult != null) {
          r.put("msg", "检测成功").put("data", jsonResult);
        } else {
          r.put("code", StatusCodeConstant.THIRD_INTERFACE_ERROR).put("msg", "检测失败");
        }
      } catch (Exception e) {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
      }
      return r;
    }

    @RequestMapping("/url")
    public R general(String detectType, String url, String openId, String nickName) {
        R r = new R();
        if (url == null) {
            return R.error().put("msg", "图片地址不能为空");
        }
        try {
            GetMethod is =  HttpUtils.URLGet(url, new HashMap<String, String>());
            byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
            JSONResult jsonResult = handleDetect(detectType, openId, nickName, image, "");
            if (jsonResult != null) {
                r.put("msg", "检测成功").put("data", jsonResult);
            } else {
                r.put("code", StatusCodeConstant.THIRD_INTERFACE_ERROR).put("msg", "检测失败");
            }
            is.releaseConnection();
            is = null;
        } catch (Exception e) {
            r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
        }
        return r;
    }

    private JSONResult handleDetect(String detectType, String openId, String nickName, byte[] image, String filePath) throws Exception{
        JSONResult jsonResult = JSONResult.build();
        HashMap<String, String> option = new HashMap<String, String>();
        option.put("baike_num", "1");
        if (detectType.isEmpty()) {
            detectType = "general";
        }
        JSONObject jsonObject = getDetectedObject(detectType, image, option);
        GeneralDetect detectBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), GeneralDetect.class);

        switch (detectType) {
            case "dish":
                DishDetectResp dishDetectResp = handleDishDetectedResponse(detectBean, openId, nickName, "");
                jsonResult.put("detect", dishDetectResp);
                break;
            case "car":
                CarDetectResp carDetectResp = handleCarDetectedResponse(detectBean, openId, nickName);
                jsonResult.put("detect", carDetectResp);
                break;
            case "logo":
                LogoDetectResp logoDetectResp = handleLogoDetectedResponse(detectBean, openId, nickName, "");
                jsonResult.put("detect", logoDetectResp);
                break;
            case "animal":
            case "plant":
                BiologyDetectResp biologyDetectResp = handleBiologyDetectedResponse(detectBean, openId, nickName, "");
                jsonResult.put("detect", biologyDetectResp);
                break;
            case "object":
                break;
            case "handwriting":
                break;
            case "general":
            default:
                GeneralDetectResp generalDetectResp = handleGeneralDetectedResponse(detectBean, openId, nickName);
                jsonResult.put("detect", generalDetectResp);
        }
        jsonResult.put("raw", detectBean);
        return jsonResult;
    }

    private JSONObject getDetectedObject(String detectType, byte[] image, HashMap<String, String> options) throws Exception{
        JSONObject jsonObject;
        switch (detectType) {
            case "dish":// 菜品
                jsonObject = uraAipImageClassify.dishDetect(image, options);
                break;
            case "animal": // 动物
                jsonObject = uraAipImageClassify.animalDetect(image, options);
                break;
            case "plant": // 植物
                jsonObject = uraAipImageClassify.plantDetect(image, options);
                break;
            case "ingredient":
                jsonObject = uraAipImageClassify.ingredientDetect(image, options);
                break;
            case "flower":
                jsonObject = uraAipImageClassify.flowerDetect(image, options);
                break;
            case "car": // 汽车
                jsonObject = uraAipImageClassify.carDetect(image, options);
                break;
            case "logo": // 商标
                jsonObject = uraAipImageClassify.logoSearch(image, options);
                break;
            default:
                jsonObject = uraAipImageClassify.advancedGeneral(image, options);
                break;
        }
        return jsonObject;
    }
    private DishDetectResp handleDishDetectedResponse(GeneralDetect cgb, String openId, String nickName, String imagePath) {
        DishDetectResp detectResp = new DishDetectResp();
        if (cgb.getResult() != null) {
            DishDetectEntity dishDetectEntity = new DishDetectEntity();
            dishDetectEntity.setOpenId(openId);
            dishDetectEntity.setNickname(nickName);
            dishDetectEntity.setLogId(String.valueOf(cgb.getLog_id()));
            dishDetectEntity.setResultNum(cgb.getResult_num());
            dishDetectEntity.setCalorie(cgb.getResult().get(0).getCalorie());
            dishDetectEntity.setHasCalorie(String.valueOf(cgb.getResult().get(0).isHas_calorie()));
            dishDetectEntity.setDishName(cgb.getResult().get(0).getName());
            dishDetectEntity.setProbability(cgb.getResult().get(0).getProbability());
            dishDetectEntity.setImagePath(imagePath);
            dishDetectEntity.setBaikeUrl(cgb.getResult().get(0).getBaike_info().getBaikeUrl());
            dishDetectEntity.setImageUrl(cgb.getResult().get(0).getBaike_info().getImageUrl());
            dishDetectEntity.setDescription(cgb.getResult().get(0).getBaike_info().getDescription());
            // TODO save to db

            // 返回数据到客户端
            detectResp.setCalorie(cgb.getResult().get(0).getCalorie() + "KJ/100g");
            detectResp.setHasCalorie(cgb.getResult().get(0).isHas_calorie() ? "是" : "否");
            detectResp.setName(cgb.getResult().get(0).getName());
            detectResp.setBaikeUrl(cgb.getResult().get(0).getBaike_info().getBaikeUrl());
            detectResp.setBaikeImageUrl(cgb.getResult().get(0).getBaike_info().getImageUrl());
            detectResp.setBaikeDescription(cgb.getResult().get(0).getBaike_info().getDescription());
            detectResp.setProbability(getPercent(Double.parseDouble(cgb.getResult().get(0).getProbability()) * 100));
        }
        return detectResp;
    }
    private BiologyDetectResp handleBiologyDetectedResponse(GeneralDetect generalDetect, String openId, String nickName, String imagePath) {
        BiologyDetectResp biologyDetectResp = new BiologyDetectResp();
        if (generalDetect.getResult() != null) {
            ResultBean result = generalDetect.getResult().get(0);
            biologyDetectResp.setName(result.getName());
            biologyDetectResp.setScore(getPercent(Double.parseDouble(result.getScore()) * 100));
            biologyDetectResp.setBaikeUrl(result.getBaike_info().getBaikeUrl());
            biologyDetectResp.setBaikeImageUrl(result.getBaike_info().getImageUrl());
            biologyDetectResp.setBaikeDescription(result.getBaike_info().getDescription());
        }
        return biologyDetectResp;
    }
    private LogoDetectResp handleLogoDetectedResponse(GeneralDetect generalDetect, String openId, String nickName, String imagePath) {
        LogoDetectResp logoDetectResp = new LogoDetectResp();
        if (generalDetect.getResult() != null) {
            ResultBean result = generalDetect.getResult().get(0);
            logoDetectResp.setName(result.getName());
            logoDetectResp.setResultNum(generalDetect.getResult_num());
            logoDetectResp.setProbability(result.getProbability());
            logoDetectResp.setType(result.getLogoType());
            logoDetectResp.setWidth(result.getLocation().getWidth());
            logoDetectResp.setHeight(result.getLocation().getHeight());
            logoDetectResp.setLeft(result.getLocation().getLeft());
            logoDetectResp.setTop(result.getLocation().getTop());
        }
        return logoDetectResp;
    }
    private CarDetectResp handleCarDetectedResponse(GeneralDetect generalDetect, String openId, String nickName) {
        CarDetectResp carDetectResp = new CarDetectResp();
        if (generalDetect.getResult() != null) {
            ResultBean result = generalDetect.getResult().get(0);
            carDetectResp.setName(result.getName());
            carDetectResp.setColorResult(generalDetect.getColor_result());
            carDetectResp.setYear(result.getYear());
            carDetectResp.setBaikeUrl(result.getBaike_info().getBaikeUrl());
            carDetectResp.setBaikeImageUrl(result.getBaike_info().getImageUrl());
            carDetectResp.setBaikeDescription(result.getBaike_info().getDescription());
            carDetectResp.setWidth(generalDetect.getLocation_result().getWidth());
            carDetectResp.setHeight(generalDetect.getLocation_result().getHeight());
            carDetectResp.setLeft(generalDetect.getLocation_result().getLeft());
            carDetectResp.setTop(generalDetect.getLocation_result().getTop());
        }
        return carDetectResp;
    }
    private GeneralDetectResp handleGeneralDetectedResponse(GeneralDetect generalDetect, String openId, String nickName) {
        GeneralDetectResp generalDetectResp = new GeneralDetectResp();
        if (generalDetect.getResult() != null) {
            ResultBean result = generalDetect.getResult().get(0);
            generalDetectResp.setResultNum(generalDetect.getResult_num());
            generalDetectResp.setTag(result.getRoot());
            generalDetectResp.setKeyword(result.getKeyword());
            generalDetectResp.setScore(getPercent(Double.parseDouble(result.getScore()) * 100));
            generalDetectResp.setBaikeUrl(result.getBaike_info().getBaikeUrl());
            generalDetectResp.setBaikeImageUrl(result.getBaike_info().getImageUrl());
            generalDetectResp.setBaikeDescription(result.getBaike_info().getDescription());
        }
        return  generalDetectResp;
    }

    private String getPercent(double num) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formatString = decimalFormat.format(num);
        Double result = Double.valueOf(formatString);
        return result + "%";
    }

  private String getPrefix(String detectType) {
    String prefix = "";
    switch (detectType){
      case "dish":
        prefix = "ic-dish";
        break;
      case "logo":
        prefix = "ic-logo";
        break;
      case "car":
        prefix = "ic-car";
        break;
      case "animal":
        prefix = "ic-animal";
        break;
      case "plant":
        prefix = "ic-plant";
        break;
      default:
        prefix = "ic";
        break;
    }
    return prefix;
  }
}
