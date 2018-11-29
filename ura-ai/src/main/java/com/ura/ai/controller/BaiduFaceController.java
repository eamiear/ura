/**
 * @author eamiear
 * @date 2018/11/29 11:43
 * 百度人脸识别
 */

package com.ura.ai.controller;

import com.baidu.aip.face.AipFace;
import com.ura.common.constant.AIConstant;
import com.ura.common.utils.JSONResult;
import com.ura.common.utils.R;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequestMapping("bd/face")
public class BaiduFaceController {

    @RequestMapping("/detect")
    public R detect(@RequestParam(value = "file")MultipartFile file, String openId, String nickName) {

        String url = "https://gss0.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/8694a4c27d1ed21b2b25b386ab6eddc450da3fe0.jpg";
        AipFace client = new AipFace(AIConstant.BD_FACE_APPID, AIConstant.BD_FACE_APPKEY, AIConstant.BD_FACE_APPSECRET);

        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        JSONObject res = client.detect(url, "URL", options);
        com.alibaba.fastjson.JSONObject detection = com.alibaba.fastjson.JSONObject.parseObject(res.toString());
        return R.success().put("data", JSONResult.build().put("detect", detection));
    }

    @RequestMapping("/compare")
    public R compare () {
        return R.success();
    }
}
