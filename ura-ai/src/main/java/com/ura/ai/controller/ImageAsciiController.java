/**
 * @author eamiear
 * @date 2018/12/7 13:40
 */

package com.ura.ai.controller;

import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Objects;

@RestController
@RequestMapping("/rest/iac")
public class ImageAsciiController {
  public R imaeg2ascii(@RequestParam(value = "file") MultipartFile file) {
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "图片不能为空");
    }
    try {
      byte[] image = file.getBytes();
      InputStream inputStream = new ByteArrayInputStream(image);
      BufferedImage bufferedImage = ImageIO.read(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
