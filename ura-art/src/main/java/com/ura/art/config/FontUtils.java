package com.ura.art.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.awt.*;
import java.io.File;

public class FontUtils {
  private static Logger logger = LoggerFactory.getLogger(FontUtils.class);
  private static final Font SERIF_FONT = new Font("serif", Font.PLAIN, 24);

  public static Font getFont(String name) {
    Font font = null;
    if (name == null) {
      return SERIF_FONT;
    }

    try {
//      // load from a cache map, if exists
//      if (fonts != null && (font = fonts.get(name)) != null) {
//        return font;
//      }
//      String fName = Params.get().getFontPath() + name;

      File fontFile = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "fonts/" + name + ".ttf");
//      File fontFile = new File("classpath:fonts/" + name + ".tff");
//      Resource resource = new ClassPathResource("fonts/" + name + ".ttf");
//      File fontFile = resource.getFile();
      font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
      font = font.deriveFont(24L);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);
    } catch (Exception ex) {
      logger.info(name + " not loaded.  Using serif font.");
      font = SERIF_FONT;
    }
    return font;
  }
}
