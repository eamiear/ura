package com.ura.art.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ura.art.bean.JiqieBean;
import com.ura.art.config.DrawerUtils;
import com.ura.common.utils.HttpUtil;
import com.ura.common.utils.JSONResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

/**
 * @author eamiear
 * @date 2018/9/13 15:30
 */

@Component
public class ArtService {

//  private Logger logger = LoggerFactory.getLogger(ArtService.class);

  @Autowired
  private JiqieBean jiqieBean;

  /**
   * 生成签名图片<img>标签
   * param name
   * @param fontFamily
   * @param background
   * @param decorator
   * @param color
   * @return
   */
  public String createSignatureImageViaThirdServer(String name, String fontFamily, String background, String decorator, String color) {
    Map<String, Object> params = JSONResult.build()
            .put("id", name)
            .put("idi", jiqieBean.getHost())
            .put("id1", fontFamily)
            .put("id2", background)
            .put("id4", decorator)
            .put("id6", color);
    return HttpUtil.URLPost(jiqieBean.getUrl(), params, true);
  }

  /**
   * 截图图片有效路径
   * @param imageTag
   * @return
   */
  public String getUrlFromSignatureImageTag(String imageTag) {
    if (null == imageTag) return "";
    return imageTag.substring(imageTag.indexOf("/"), imageTag.lastIndexOf("?"));
  }

  /**
   * 获取图片访问路径
   * @param partial
   * @return
   */
  public String getVisitedImageUrl(String partial){
    if (null == partial) return "";
    jiqieBean.setSuffix(partial.substring(partial.lastIndexOf(".") + 1));
    return jiqieBean.getDomain() + partial;
  }

  /**
   * 移除水印
   * @param name
   * @param fontFamily
   * @param background
   * @param decorator
   * @param color
   * @return
   * @throws Exception
   */
  public BufferedImage removeWatermark(String name, String fontFamily, String background, String decorator, String color) throws Exception{
    String imageContent = createSignatureImageViaThirdServer(name, fontFamily, background, decorator, color);
    String partialUrl = getUrlFromSignatureImageTag(imageContent);
    String remoteUrl = getVisitedImageUrl(partialUrl);
    BufferedImage bi = DrawerUtils.cutRemoteImage(
            remoteUrl,
            Integer.valueOf(jiqieBean.getRectX()),
            Integer.valueOf(jiqieBean.getRectY()),
            Integer.valueOf(jiqieBean.getRectWidth()),
            Integer.valueOf(jiqieBean.getRectHeight()));

    return bi;
  }

  public void write(BufferedImage bi, String suffix, HttpServletResponse response) throws Exception{
    if (StringUtils.isBlank(suffix)) {
      suffix = "png";
    }
    if (jiqieBean.getSuffix() != null) {
      suffix = jiqieBean.getSuffix();
    }
    ImageIO.write(bi, suffix, response.getOutputStream());
  }

  public void write(BufferedImage bi, HttpServletResponse response) throws Exception{
    write(bi, "png", response);
  }

}
