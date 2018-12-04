/**
 * @author eamiear
 * @date 2018/12/4 11:38
 */

package com.ura.ai.controller;

import com.ura.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("rest/ocr")
public class BaiduOcrController {

    @RequestMapping("/detect/file")
    public R detect(@RequestParam(value = "file")MultipartFile file, String ocrType, String languageType, String openId, String nickName) {
        return R.success();
    }
    @RequestMapping("/detect/url")
    public R detect(String url, String openId, String ocrType, String languageType, String nickName) {
        return R.success();
    }
}
