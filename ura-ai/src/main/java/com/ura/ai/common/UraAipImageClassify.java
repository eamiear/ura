/**
 * @author eamiear
 * @date 2018/12/3 13:48
 */

package com.ura.ai.common;

import com.baidu.aip.error.AipError;
import com.baidu.aip.http.AipRequest;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class UraAipImageClassify extends AipImageClassify {
    //食材识别接口
    private static final String INGREDIENT_DETECT = "https://aip.baidubce.com/rest/2.0/image-classify/v1/classify/ingredient";
    //花卉识别接口
    private static final String FLOWER_DETECT = "https://aip.baidubce.com/rest/2.0/image-classify/v1/flower";
    //手写文字识别
    private static final String HANDWRITING_DETECT = "https://aip.baidubce.com/rest/2.0/ocr/v1/handwriting";

    public UraAipImageClassify(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }

    public JSONObject ingredientDetect(byte[] image, HashMap<String, String> options) {
        return this.detect(image, options, INGREDIENT_DETECT);
    }
    public JSONObject ingredientDetect(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return this.ingredientDetect(data, options);
        } catch (IOException var4) {
            var4.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }
    public JSONObject flowerDetect(byte[] image, HashMap<String, String> options) {
        return this.detect(image, options, FLOWER_DETECT);
    }
    public JSONObject flowerDetect(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return this.flowerDetect(data, options);
        } catch (IOException var4) {
            var4.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }
    public JSONObject handwritingDetect(byte[] image, HashMap<String, String> options) {
        return this.detect(image, options, HANDWRITING_DETECT);
    }
    public JSONObject handwritingDetect(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return this.handwritingDetect(data, options);
        } catch (IOException var4) {
            var4.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }
    private JSONObject detect(byte[] image, HashMap<String, String> options, String uri) {
        AipRequest request = new AipRequest();
        this.preOperation(request);
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(uri);
        this.postOperation(request);
        return this.requestServer(request);
    }
}
