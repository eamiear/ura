/**
 * @author eamiear
 * @date 2018/12/4 11:38
 */

package com.ura.ai.controller;

import com.baidu.aip.ocr.AipOcr;
import com.ura.ai.common.BaiduFactory;
import com.ura.ai.common.UraAipImageClassify;
import com.ura.ai.pojo.baidu.bean.*;
import com.ura.ai.pojo.baidu.resp.*;
import com.ura.common.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest/ocr")
@Api(tags = "OCR识别")
public class BaiduOcrController {
  private static AipOcr aipOcr = BaiduFactory.getAipOcr();
  private static UraAipImageClassify uraAipImage = BaiduFactory.getUraAipImageClassify();

  @PostMapping("/detect/file")
  @ApiOperation("ocr检测")
  public R detect(
    @ApiParam("图片文件") @RequestParam(value = "file") MultipartFile file,
    @ApiParam("ocr类型") String ocrType, String openId, String nickName) {
    R r = new R();
    if (file == null) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请上传图片");
    }
    try {
      byte[] image = file.getBytes();
      JSONResult jsonResult = getOCRResult(ocrType, image, openId, nickName);
      if (jsonResult.get("detect") != null) {
        r.put("msg", "检测成功").put("data", jsonResult);
      } else {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", "无效识别");
      }
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  @RequestMapping(value = "/detect/url", method = {RequestMethod.GET, RequestMethod.POST})
  @ApiOperation("ocr检测")
  public R detect(@ApiParam("图片url") String url, String openId, @ApiParam("ocr类型") String ocrType, String nickName) {
    R r = new R();
    if (null == url) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "请输入网络图片url");
    }
    try {
      GetMethod is = HttpUtils.URLGet(url, new HashMap<String, String>());
      byte[] image = FileUtils.readStreamByBytes(is.getResponseBodyAsStream());
      JSONResult jsonResult = getOCRResult(ocrType, image, openId, nickName);
      if (jsonResult.get("detect") != null) {
        r.put("msg", "检测成功").put("data", jsonResult);
      } else {
        r.put("code", StatusCodeConstant.THIRD_INTERFACE_NODATA).put("msg", "无效识别");
      }
      is.releaseConnection();
      is = null;
    } catch (Exception e) {
      r.put("code", StatusCodeConstant.THIRD_INTERFACE_EXCEPTION).put("msg", "内部异常： " + e.getMessage());
    }
    return r;
  }

  private JSONResult getOCRResult(String ocrType, byte[] image, String openId, String nickName) {
    JSONObject jsonObject;
    JSONResult jsonResult = JSONResult.build();
    HashMap<String, String> options = new HashMap<String, String>();
    options.put("detect_direction", "true");
    switch (ocrType) {
      case "idcard-back":
        options.put("detect_risk", "true");
        jsonObject = aipOcr.idcard(image, "back", options);
        OCRIdCardBean ocrIdCard = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRIdCardBean.class);
        OCRIdCardResp ocrIdCardResp = handleOCRIdCardResponse(ocrIdCard);
        jsonResult.put("detect", ocrIdCardResp).put("raw", ocrIdCard);
        break;
      case "idcard-front":
        options.put("detect_risk", "true");
        jsonObject = aipOcr.idcard(image, "front", options);
        OCRIdCardBean ocrIdCardFront = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRIdCardBean.class);
        OCRIdCardResp ocrIdCardRespFront = handleOCRIdCardResponse(ocrIdCardFront);
        jsonResult.put("detect", ocrIdCardRespFront).put("raw", ocrIdCardFront);
        break;
      case "bank":
        options.put("detect_risk", "true");
        jsonObject = aipOcr.bankcard(image, options);
        OCRBankCardBean ocrBankCardBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRBankCardBean.class);
        OCRBankCardResp ocrBankCardResp = handleOCRBankCardResponse(ocrBankCardBean);
        jsonResult.put("detect", ocrBankCardResp).put("raw", ocrBankCardBean);
        break;
      case "plate":
        jsonObject = aipOcr.plateLicense(image, options);
        OCRPlateLicenseBean ocrPlateLicenseBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRPlateLicenseBean.class);
        OCRVehicleLicenseResp plateLicense = handleOCRPlateBeanResponse(ocrPlateLicenseBean);
        jsonResult.put("detect", plateLicense).put("raw", ocrPlateLicenseBean);
        break;
      case "receipt":
        jsonObject = aipOcr.receipt(image, options);
        OCRReceiptBean ocrReceiptBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRReceiptBean.class);
        jsonResult.put("detect", ocrReceiptBean);
        break;
      case "driving":
        jsonObject = aipOcr.drivingLicense(image, options);
        OCRVehicleBean ocrVehicleBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRVehicleBean.class);
        OCRVehicleResp ocrVehicleResp = handleOCRVehicleResponse(ocrVehicleBean);
        jsonResult.put("detect", ocrVehicleResp).put("raw", ocrVehicleBean);
        break;
      case "vehicle":
        jsonObject = aipOcr.vehicleLicense(image, options);
        OCRVehicleBean driving = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRVehicleBean.class);
        OCRVehicleResp drivingResp = handleOCRVehicleResponse(driving);
        jsonResult.put("detect", drivingResp).put("raw", driving);
        break;
      case "handwriting":
        jsonObject = uraAipImage.handwritingDetect(image, options);
        OCRReceiptBean handwriting = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRReceiptBean.class);
        jsonResult.put("detect", handwriting);
        break;
      case "general":
      default:
        jsonObject = aipOcr.basicGeneral(image, options);
        OCRGeneralBean ocrGeneralBean = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRGeneralBean.class);
        jsonResult.put("detect", ocrGeneralBean);
        break;
    }
    return jsonResult;
  }

  private OCRIdCardResp handleOCRIdCardResponse(OCRIdCardBean ocrIdCardBean) {
    OCRIdCardResp ocrIdCardResp = null;
    if (ocrIdCardBean.getWords_result() != null) {
      ocrIdCardResp = new OCRIdCardResp();
      OCRIdCardBean.WordsResult result = ocrIdCardBean.getWords_result().get(0);
      ocrIdCardResp.setName(result.getName().getWords());
      ocrIdCardResp.setAddress(result.getAddress().getWords());
      ocrIdCardResp.setBirth(result.getBirth().getWords());
      ocrIdCardResp.setIdCardNum(result.getIdCardNum().getWords());
      ocrIdCardResp.setNation(result.getNation().getWords());
      ocrIdCardResp.setSex(result.getSex().getWords());
      ocrIdCardResp.setAuthority(result.getAuthority().getWords());
      ocrIdCardResp.setWordsResultNum(ocrIdCardBean.getWords_result_num());
      ocrIdCardResp.setRiskType(getRiskType(ocrIdCardBean.getRisk_type()));
      ocrIdCardResp.setImageStatus(getImageStatus(ocrIdCardBean.getImage_status()));
      ocrIdCardResp.setEditTool(ocrIdCardBean.getEdit_tool());
      ocrIdCardResp.setIssueDate(result.getIssueDate().getWords());
      ocrIdCardResp.setExpireDate(result.getExpireDate().getWords());
    }
    return ocrIdCardResp;
  }

  private OCRBankCardResp handleOCRBankCardResponse(OCRBankCardBean ocrBankCardBean) {
    OCRBankCardResp ocrBankCardResp = null;
    if (ocrBankCardBean.getResult() != null) {
      ocrBankCardResp = new OCRBankCardResp();
      ocrBankCardResp.setBankName(ocrBankCardBean.getResult().getBank_name());
      ocrBankCardResp.setBankCardNumber(ocrBankCardBean.getResult().getBank_card_number());
      ocrBankCardResp.setBankCardType(getBankCardType(ocrBankCardBean.getResult().getBank_card_type()));
    }
    return ocrBankCardResp;
  }

  private OCRVehicleLicenseResp handleOCRPlateBeanResponse(OCRPlateLicenseBean ocrPlateLicenseBean) {
    OCRVehicleLicenseResp ocrVehicleLicenseResp = null;
    if (ocrPlateLicenseBean.getWords_result() != null) {
      ocrVehicleLicenseResp = new OCRVehicleLicenseResp();
      ocrVehicleLicenseResp.setColor(ocrPlateLicenseBean.getWords_result().getColor());
      ocrVehicleLicenseResp.setNumber(ocrPlateLicenseBean.getWords_result().getNumber());
    }
    return ocrVehicleLicenseResp;
  }

  private OCRVehicleResp handleOCRVehicleResponse(OCRVehicleBean ocrVehicleBean) {
    OCRVehicleResp ocrVehicleResp = null;
    if (ocrVehicleBean.getWords_result() != null) {
      ocrVehicleResp = new OCRVehicleResp();
      OCRVehicleBean.WordsResult result = ocrVehicleBean.getWords_result().get(0);
      ocrVehicleResp.setAddress(result.getAddress().getWords());
      ocrVehicleResp.setBrandModel(result.getBrandModel().getWords());
      ocrVehicleResp.setEngineNumber(result.getEngineNumber().getWords());
      ocrVehicleResp.setIssueDate(result.getIssueDate().getWords());
      ocrVehicleResp.setOwner(result.getOwner().getWords());
      ocrVehicleResp.setPlateNumber(result.getPlateNumber().getWords());
      ocrVehicleResp.setRegistryDate(result.getRegistryDate().getWords());
      ocrVehicleResp.setUsageNature(result.getUsageNature().getWords());
      ocrVehicleResp.setVehicleType(result.getVehicleType().getWords());
      ocrVehicleResp.setVehicleIdentificationCode(result.getVehicleIdentificationCode().getWords());
    }
    return ocrVehicleResp;
  }

  private String getDirection(String type) {
    String text = "";
    switch (type) {
      case "--1":
        text = "未定义";
        break;
      case "0":
        text = "正向";
        break;
      case "-1":
        text = "逆时针90度";
        break;
      case "-2":
        text = "正向";
        break;
    }
    return text;
  }

  private String getRiskType(String type) {
    Map<String, String> risk = new HashMap<String, String>();
    risk.put("normal", "正常身份证");
    risk.put("copy", "复印件");
    risk.put("temporary", "临时身份证");
    risk.put("screen", "翻拍");
    risk.put("unknown", "其他未知情况");
    return risk.get(type);
  }

  private String getBankCardType(int type) {
    List<String> cardList = new ArrayList<>();
    cardList.add("不能识别");
    cardList.add("借记卡");
    cardList.add("信用卡");
    return cardList.get(type);
  }

  private String getImageStatus(String type) {
    Map<String, String> status = new HashMap<String, String>();
    status.put("normal", "识别正常");
    status.put("reversed_side", "未摆正身份证");
    status.put("non_idcard", "上传的图片中不包含身份证");
    status.put("blurred", "身份证模糊");
    status.put("over_exposure", "身份证关键字段反光或过曝");
    status.put("unknown", "未知状态");
    return status.get(type);
  }
}
