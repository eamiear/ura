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
import com.ura.common.utils.R;
import com.ura.taip.face.TAipFace;
import com.ura.taip.ptu.TAipPtu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("rest/ptu")
public class TencentPtuController {
  private static Logger logger = LoggerFactory.getLogger(TencentPtuController.class);
  TAipFace tAipFace = TencentFactory.createTAipFace();
  TAipPtu tAipPtu = TencentFactory.createTAipPtu();
  AipFace aipFace = BaiduFactory.getAipFace();

  @RequestMapping("/face/merge/file")
  public R faceMerge(@RequestParam(value = "file")MultipartFile file, Integer model) {
    R r = new R();
    try {
      byte[] image = file.getBytes();
      String reuslt = tAipPtu.faceMerge(image, model);
      JSONObject jsonObject = JSON.parseObject(reuslt);
      if (jsonObject.getInteger("ret") != 0) {
        r.put("code", jsonObject.getInteger("ret")).put("msg", jsonObject.getString("msg"));
      } else {
        r.put("detect", jsonObject);
      }
      return r;
    } catch (IOException e) {
      e.printStackTrace();
      r.put("msg", "");
    }
  }
}
