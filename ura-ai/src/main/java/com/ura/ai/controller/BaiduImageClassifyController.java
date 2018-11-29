/**
 * @author eamiear
 * @date 2018/11/29 15:47
 * 百度图像识别
 */

package com.ura.ai.controller;

import com.ura.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bd/image")
public class BaiduImageClassifyController {
    /**
     * 图像识别
     * @param type
     * @return
     */
    @RequestMapping("/general")
    public R general(@RequestParam int type){
        return R.success();
    }
}
