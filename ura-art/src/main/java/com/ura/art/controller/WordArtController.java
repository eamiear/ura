package com.ura.art.controller;

import com.ura.art.config.DrawerUtils;
import com.ura.art.config.FontUtils;
import com.ura.common.utils.HttpUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/art")
public class WordArtController {

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
}
