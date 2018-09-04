package com.ura.art.controller;

import com.ura.art.config.DrawerUtils;
import com.ura.art.config.FontUtils;
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
}
