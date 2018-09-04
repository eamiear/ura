package com.ura.art.controller;

import com.ura.art.config.DrawerUtils;
import com.ura.art.config.FontUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.io.File;
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
}
