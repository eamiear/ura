package com.ura.art.controller;

import com.ura.art.bean.SignatureReq;
import com.ura.art.config.DrawerUtils;
import com.ura.art.config.FontUtils;
import com.ura.art.service.ArtService;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

@Controller
@RequestMapping("/art")
public class WordArtController {

  @Autowired
  private ArtService artService;

  private final static String SIGN_BG = "#ffffff";
  private final static int COLOR_RANGE = 120;

  @RequestMapping("/word")
  public void word() {
    Font font = FontUtils.getFont("2");
    File file = new File("E:\\fonts\\");
    try {
      DrawerUtils.createImage("姜育恒", font, file, 100, 100);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @RequestMapping("/generate")
  public void word(HttpServletRequest request, HttpServletResponse response) {
    String id = request.getParameter("id");
    Float size = Float.valueOf(request.getParameter("size"));
    String text = request.getParameter("text");
    Integer width = Integer.valueOf(StringUtils.isBlank(request.getParameter("width")) ? "150" : request.getParameter("width"));
    Integer height = Integer.valueOf(StringUtils.isBlank(request.getParameter("height")) ? "150" : request.getParameter("height"));
    try {
      Font font = FontUtils.getFont(id);
      if (size != 0) {
        font = font.deriveFont(size);
      }
      BufferedImage image = DrawerUtils.createImage(text, font, width, height);
      ImageIO.write(image, "png", response.getOutputStream());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @RequestMapping("/create")
  public void create(
          @RequestParam("id") String id,
          @RequestParam(value = "size", required = false) Float size,
          @RequestParam("text") String text,
          @RequestParam(value = "width", required = false) Integer width,
          @RequestParam(value = "height", required = false) Integer height,
          HttpServletResponse response) {
    try {
      Font font = FontUtils.getFont(id);
      if (size != null) {
        font = font.deriveFont(size);
      }
      BufferedImage image = DrawerUtils.createAtRatio(text, font, width, height);
      ImageIO.write(image, "png", response.getOutputStream());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @RequestMapping("/alpha")
  public void alpha() {
    try {
      BufferedImage bi = artService.removeWatermark("江育恒", "901", "#ffffff", "#ffffff", "#000000");
//      DrawerUtils.alpha(bi, "F:\\alpha.png");
      DrawerUtils.transparent(bi, "F:\\test\\alpha.png");
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  /**
   *
   * @param text       签名名称
   * @param style      字体类型
   * @param decorator   签名装饰配色
   * @param color       签名颜色
   * @param response     响应
   * @return
   */
  @RequestMapping("/signature/create")
  @ResponseBody
  public R create(
          @RequestParam(value = "text", defaultValue = "周杰伦") String text,
          @RequestParam(value = "style", defaultValue = "901") String style,
//          @RequestParam(value = "background", defaultValue = "#ffffff") String background,
          @RequestParam(value = "decorator", defaultValue = "#ffffff") String decorator,
          @RequestParam(value = "color", defaultValue = "#000000") String color,
          HttpServletResponse response){
    if (StringUtils.isBlank(text)) {
      return R.error(StatusCodeConstant.PARAM_NOT_EMPTY, "请输入姓名");
    }
    if (text.length() < 2) {
      return R.error(StatusCodeConstant.PARAM_SIZE_INVALID, "请输入至少两个字");
    }
    try {
      BufferedImage bi = artService.removeWatermark(text, style, handleColor(SIGN_BG), handleColor(decorator), handleColor(color));
//      bi = DrawerUtils.transparentImage(bi, COLOR_RANGE, 0);
//      bi = DrawerUtils.alpha1(bi);
//      BufferedImage scaleImage = DrawerUtils.scaleImage(bi, 350, 160);
      artService.write(bi, response);
//      artService.write(scaleImage, response);
//      ImageIO.write(scaleImage, "png", new File("F:\\scale.png"));
      return R.success();
    } catch (Exception e) {
      return R.error().put("msg", e);
    }
  }

  /**
   *
   * @param text       签名名称
   * @param style      字体类型
   * @param decorator   签名装饰配色
   * @param color       签名颜色
   * @param response     响应
   * @return
   */
  @RequestMapping("/signature/alpha")
  @ResponseBody
  public R alpha (
        @RequestParam(value = "text", defaultValue = "周杰伦") String text,
        @RequestParam(value = "style", defaultValue = "901") String style,
        @RequestParam(value = "decorator", defaultValue = "#ffffff") String decorator,
        @RequestParam(value = "color", defaultValue = "#000000") String color,
        HttpServletResponse response) {
    if (StringUtils.isBlank(text)) {
      return R.error(StatusCodeConstant.PARAM_NOT_EMPTY, "请输入姓名");
    }
    if (text.length() < 2) {
      return R.error(StatusCodeConstant.PARAM_SIZE_INVALID, "请输入至少两个字");
    }
    try {
      BufferedImage bi = artService.removeWatermark(text, style, handleColor(SIGN_BG), handleColor(decorator), handleColor(color));
      bi = DrawerUtils.transparentImage(bi, COLOR_RANGE, 0);
//      bi = DrawerUtils.alpha1(bi);
      artService.write(bi, response);
      return R.success();
    } catch (Exception e) {
      return R.error().put("msg", e);
    }
  }

  /**
   *
   * @param text       签名名称
   * @param style      字体类型
   * @param decorator   签名装饰配色
   * @param color       签名颜色
   * @param width       缩放|扩大宽度
   * @param height      缩放|扩大高度
   * @param response     响应
   * @return
   */
  @RequestMapping("/signature/scale")
  @ResponseBody
  public R scale(
      @RequestParam(value = "text", defaultValue = "周杰伦") String text,
      @RequestParam(value = "style", defaultValue = "901") String style,
      @RequestParam(value = "decorator", defaultValue = "#ffffff") String decorator,
      @RequestParam(value = "color", defaultValue = "#000000") String color,
      @RequestParam(value ="width", defaultValue = "350") int width,
      @RequestParam(value ="width", defaultValue = "160") int height,
      HttpServletResponse response) {
    if (StringUtils.isBlank(text)) {
      return R.error(StatusCodeConstant.PARAM_NOT_EMPTY, "请输入姓名");
    }
    if (text.length() < 2) {
      return R.error(StatusCodeConstant.PARAM_SIZE_INVALID, "请输入至少两个字");
    }
    try {
      BufferedImage bi = artService.removeWatermark(text, style, handleColor(SIGN_BG), handleColor(decorator), handleColor(color));
      bi = DrawerUtils.transparentImage(bi, COLOR_RANGE, 0);
      bi = DrawerUtils.alpha1(bi);
      BufferedImage scaleImage = DrawerUtils.scaleImage(bi, width, height);
//      bi = DrawerUtils.alpha1(bi);
      artService.write(scaleImage, response);
      return R.success();
    } catch (Exception e) {
      return R.error().put("msg", e);
    }
  }

  private String handleColor(String color){
    if (!color.contains("#")) {
      color = "#" + color;
    }
    return color;
  }
}
