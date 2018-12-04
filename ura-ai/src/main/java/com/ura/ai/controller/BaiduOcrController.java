/**
 * @author eamiear
 * @date 2018/12/4 11:38
 */

package com.ura.ai.controller;

import com.baidu.aip.ocr.AipOcr;
import com.ura.ai.common.BaiduFactory;
import com.ura.ai.common.UraAipImageClassify;
import com.ura.ai.pojo.baidu.bean.OCRIdCardBean;
import com.ura.ai.pojo.baidu.resp.OCRIdCardResp;
import com.ura.common.utils.JSONResult;
import com.ura.common.utils.R;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequestMapping("rest/ocr")
public class BaiduOcrController {
    private static AipOcr aipOcr = BaiduFactory.getAipOcr();
    private static UraAipImageClassify uraAipImage = BaiduFactory.getUraAipImageClassify();

    @RequestMapping("/detect/file")
    public R detect(@RequestParam(value = "file")MultipartFile file, String ocrType, String languageType, String openId, String nickName) {
        return R.success();
    }
    @RequestMapping("/detect/url")
    public R detect(String url, String openId, String ocrType, String languageType, String nickName) {
        return R.success();
    }

    private JSONResult handleOCRResponse(String ocrType, byte[] image, String openId, String nickName){
        JSONResult jsonResult = JSONResult.build();
        HashMap<String, String> option = new HashMap<String, String>();
        option.put("detect_direction", "true");
    }

    private JSONObject getOCRObject(String ocrType, byte[] image, HashMap<String, String> options) {
        JSONObject jsonObject;
        switch (ocrType) {
            case "idcard-back":
                options.put("detect_risk", "true");
                jsonObject = aipOcr.idcard(image, "back", options);
                OCRIdCardBean ocrIdCard = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), OCRIdCardBean.class);
                break;
            case "idcard-front":
                options.put("detect_risk", "true");
                jsonObject = aipOcr.idcard(image, "front", options);
                break;
            case "bank":
                options.put("detect_risk", "true");
                jsonObject = aipOcr.bankcard(image, options);
                break;
            case "plate":
                jsonObject = aipOcr.plateLicense(image, options);
                break;
            case "receipt":
                jsonObject = aipOcr.receipt(image, options);
                break;
            case "driving":
                jsonObject = aipOcr.drivingLicense(image, options);
                break;
            case "vehicle":
                jsonObject = aipOcr.vehicleLicense(image, options);
                break;
            case "handwriting":
                jsonObject = uraAipImage.handwritingDetect(image, options);
                break;
            case "general":
            default:
                jsonObject = aipOcr.basicGeneral(image, options);
                break;
        }
        return jsonObject;
    }

    private OCRIdCardResp handleOCRIdCardResponse(OCRIdCardBean ocrIdCardBean, String openId, String nickName) {
        OCRIdCardResp ocrIdCardResp = new OCRIdCardResp();
        if (ocrIdCardBean.getWords_result() != null) {
            OCRIdCardBean.WordsResult result = ocrIdCardBean.getWords_result().get(0);
            ocrIdCardResp.setName(result.getName().getWords());
            ocrIdCardResp.setAddress(result.getAddress().getWords());
            ocrIdCardResp.setBirth(result.getBirth().getWords());
            ocrIdCardResp.setIdCardNum(result.getIdCardNum().getWords());
            ocrIdCardResp.setNation(result.getNation().getWords());
            ocrIdCardResp.setSex(result.getSex().getWords());
            ocrIdCardResp.setAuthority(result.getAuthority().getWords());
            ocrIdCardBean.setWords_result_num(ocrIdCardBean.getWords_result_num());


        }
    }

    private String getDirection(String type) {
        String text = "";
        switch (type){
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
}
