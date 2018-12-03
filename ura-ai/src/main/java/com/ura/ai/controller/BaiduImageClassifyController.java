/**
 * @author eamiear
 * @date 2018/11/29 15:47
 * 百度图像识别
 */

package com.ura.ai.controller;

import com.ura.ai.bean.ClassifyGeneralDetectBean;
import com.ura.ai.bean.ClassifyGeneralDetectResp;
import com.ura.ai.bean.DishDetectResp;
import com.ura.ai.common.BaiduFactory;
import com.ura.ai.common.UraAipImageClassify;
import com.ura.ai.entity.DishDetectEntity;
import com.ura.ai.entity.GeneralDetectEntity;
import com.ura.common.utils.*;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("bd/ic")
public class BaiduImageClassifyController {

    private UraAipImageClassify uraAipImageClassify = BaiduFactory.getUraAipImageClassify();

    @RequestMapping("/url")
    public String getUrl(String url) {
        return HttpUtils.URLGet(url, new HashMap<>(), "utf8");
    }
    /**
     * 图像识别
     * @return
     */
    @RequestMapping("/general")
    public R general(@RequestParam(value = "file")MultipartFile file, String openId, String nickName, HttpServletRequest request){
        return R.success();
    }

    @RequestMapping("/general/url")
    public R general(String detectType, String url, String openId, String nickName) {
        R r = new R();
        if (url == null) {
            return R.error().put("msg", "图片地址不能为空");
        }
        try {
            InputStream is =  HttpUtils.URLPost(url);
            byte[] image = FileUtils.readStreamByBytes(is);
            JSONResult jsonResult = handleDetect(detectType, openId, nickName, image, "");
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

    private JSONResult handleDetect(String detectType, String openId, String nickName, byte[] image, String filePath) {
        JSONResult jsonResult = JSONResult.build();
        ClassifyGeneralDetectResp detectResp = null;
        HashMap<String, String> option = new HashMap<String, String>();
        option.put("top_num", "1");
        option.put("baike_num", "1");
        if (detectType.isEmpty()) {
            detectType = "general";
        }
        JSONObject jsonObject = getDetectObject(detectType, image, option);
        ClassifyGeneralDetectBean detectBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), ClassifyGeneralDetectBean.class);

        if (detectType.equals("dish")) {
            DishDetectResp dishDetectResp = getDishResponseData(detectBean, openId, nickName, "");
            jsonResult.put("detect", dishDetectResp);
        } else {
            detectResp = getBiologyData(detectBean, openId, nickName, detectType);
            jsonResult.put("detect", detectResp);
        }
        return jsonResult;
    }

    private JSONObject getDetectObject(String detectType, byte[] image, HashMap<String, String> options) {
        JSONObject jsonObject;
        switch (detectType) {
            case "dish":
                jsonObject = uraAipImageClassify.dishDetect(image, options);
                break;
            case "animal":
                jsonObject = uraAipImageClassify.animalDetect(image, options);
                break;
            case "plant":
                jsonObject = uraAipImageClassify.plantDetect(image, options);
                break;
            case "ingredient":
                jsonObject = uraAipImageClassify.ingredientDetect(image, options);
                break;
            case "flower":
                jsonObject = uraAipImageClassify.flowerDetect(image, options);
                break;
            case "car":
                jsonObject = uraAipImageClassify.carDetect(image, options);
                break;
            case "logo":
                jsonObject = uraAipImageClassify.logoSearch(image, options);
                break;
            default:
                jsonObject = uraAipImageClassify.advancedGeneral(image, options);
                break;
        }
        return jsonObject;
    }

    private DishDetectResp getDishResponseData(ClassifyGeneralDetectBean cgb, String openId, String nickName, String imagePath) {
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
            dishDetectEntity.setBaikeUrl(cgb.getResult().get(0).getBaike_info().getBaike_url());
            dishDetectEntity.setImageUrl(cgb.getResult().get(0).getBaike_info().getImage_url());
            dishDetectEntity.setDescription(cgb.getResult().get(0).getBaike_info().getDescription());

            // TODO save to db
            detectResp.setCalorie(cgb.getResult().get(0).getCalorie() + "KJ/100g");
            detectResp.setHasCalorie(cgb.getResult().get(0).isHas_calorie() ? "是" : "否");
            detectResp.setName(cgb.getResult().get(0).getName());
            detectResp.setBaikeUrl(cgb.getResult().get(0).getBaike_info().getBaike_url());
            detectResp.setImageUrl(cgb.getResult().get(0).getBaike_info().getImage_url());
            detectResp.setDescription(cgb.getResult().get(0).getBaike_info().getDescription());
            detectResp.setProbability(getPercent(Double.parseDouble(cgb.getResult().get(0).getProbability()) * 100));
        }
        return detectResp;
    }

    private ClassifyGeneralDetectResp getBiologyData(ClassifyGeneralDetectBean cgb, String openId, String nickname, String detectType) {
        ClassifyGeneralDetectResp detectResp = new ClassifyGeneralDetectResp();
        detectResp.setName(cgb.getResult().get(0).getName());
        detectResp.setScore(getPercent(Double.parseDouble(cgb.getResult().get(0).getScore()) * 100));
        detectResp.setProbability(getPercent(Double.parseDouble(cgb.getResult().get(0).getProbability()) * 100));
        detectResp.setColorResult(cgb.getColor_result());
        detectResp.setYear(cgb.getResult().get(0).getYear());
        detectResp.setBaikeUrl(cgb.getResult().get(0).getBaike_info().getBaike_url());
        detectResp.setImageUrl(cgb.getResult().get(0).getBaike_info().getImage_url());
        detectResp.setDescription(cgb.getResult().get(0).getBaike_info().getDescription());

        // TODO save to db
        GeneralDetectEntity detectEntity = new GeneralDetectEntity();
        detectEntity.setOpenId(openId);
        detectEntity.setNickname(nickname);
        detectEntity.setDetectType(detectType);
        detectEntity.setLogId(String.valueOf(cgb.getLog_id()));
        detectEntity.setResultNum(cgb.getResult_num());
        detectEntity.setName(cgb.getResult().get(0).getName());

        detectEntity.setYear(cgb.getResult().get(0).getYear());
        detectEntity.setColorResult(cgb.getColor_result());
        detectEntity.setScore(cgb.getResult().get(0).getScore());
        detectEntity.setProbability(cgb.getResult().get(0).getProbability());

        detectEntity.setLocalWidth(cgb.getResult().get(0).getLocation().getWidth());
        detectEntity.setLocalHeight(cgb.getResult().get(0).getLocation().getHeight());
        detectEntity.setLocalLeft(cgb.getResult().get(0).getLocation().getLeft());
        detectEntity.setLocalTop(cgb.getResult().get(0).getLocation().getTop());

        detectEntity.setLogoType(String.valueOf(cgb.getResult().get(0).getLogoType()));
        detectEntity.setImagePath("");

        detectEntity.setBaikeUrl(cgb.getResult().get(0).getBaike_info().getBaike_url());
        detectEntity.setBaikeImageUrl(cgb.getResult().get(0).getBaike_info().getImage_url());
        detectEntity.setBaikeDescription(cgb.getResult().get(0).getBaike_info().getDescription());

        return detectResp;
    }

    private String getPercent(double num) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formatString = decimalFormat.format(num);
        Double result = Double.valueOf(formatString);
        return result + "%";
    }
}
