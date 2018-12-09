/**
 * @author eamiear
 * @date 2018/12/7 13:40
 */

package com.ura.ai.controller;

import com.ura.common.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/rest/iac")
@Api(tags = "图片转ASCII图片")
public class ImageAsciiController {
  @RequestMapping(value = "/ascii/file", method = RequestMethod.POST)
  @ApiOperation("图片文件转ASCII")
  public R image2ascii(@ApiParam(name = "图片") @RequestParam(value = "file") MultipartFile file) {
    if (Objects.isNull(file)) {
      return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "图片不能为空");
    }
    try {
      byte[] image = file.getBytes();
      InputStream inputStream = new ByteArrayInputStream(image);
      BufferedImage bufferedImage = ImageIO.read(inputStream);
      String imageBase64 = ImageUtils.txtToImageByBase64(bufferedImage);
      if (StringUtils.isEmpty(imageBase64)) {
        return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "转换失败");
      } else {
        return R.success().put("data", JSONResult.build().put("image", imageBase64));
      }
    } catch (Exception e) {
      e.printStackTrace();
      return R.error().put("code", StatusCodeConstant.SYSTEM_INNER_ERROR).put("msg", "系统内部错误");
    }
  }

  @RequestMapping("/ascii/url")
  @ApiOperation("网络图片转为ASCII图片")
  public R image2ascii(@ApiParam(name = "图片url") String url) {
    if (null == url) {
      return R.error().put("msg", "请输入网络图片url");
    }
    try {
      GetMethod getMethod = HttpUtils.URLGet(url, new HashMap<String, String>());
      BufferedImage bufferedImage = ImageIO.read(getMethod.getResponseBodyAsStream());
      String imageBase64 = ImageUtils.txtToImageByBase64(bufferedImage);
      getMethod.releaseConnection();
      getMethod = null;
      if (StringUtils.isEmpty(imageBase64)) {
        return R.error().put("code", StatusCodeConstant.PARAM_NOT_EMPTY).put("msg", "转换失败");
      } else {
        return R.success().put("data", JSONResult.build().put("image", imageBase64));
      }
    } catch (Exception e) {
      e.printStackTrace();
      return R.error().put("code", StatusCodeConstant.SYSTEM_INNER_ERROR).put("msg", "系统内部错误");
    }
  }
}
