package com.ura.art.config;

import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DrawerUtils {
  public static float getRatio(int target, int ref){
    return (target - ref) / 2;
  }
  public static int getWordWidth(Font font, String content) {
    FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
    int width = 0;
    for (int i = 0; i < content.length(); i++) {
      width += metrics.charWidth(content.charAt(i));
    }
    return width;
  }

  public static void write(BufferedImage image, File file) throws IOException{
    if (!file.getParentFile().exists()){
      file.getParentFile().mkdirs();
    }
    try (OutputStream os = new FileOutputStream(file)){
      ImageIO.write(image, "PNG", os);
    }
  }
  public static void createImage(String str, Font font, File file, Integer width, Integer height) throws Exception{
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
    Graphics g = image.getGraphics();
    g.setClip(0, 0, width, height);
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.black);
    g.setFont(font);

    Rectangle clip = g.getClipBounds();
    FontMetrics fm = g.getFontMetrics(font);
    int ascent = fm.getAscent();
    int descent = fm.getDescent();
    int y = (clip.height - (ascent + descent)) / 2 + ascent;
    for (int i =0; i < 6; i++) {
      g.drawString(str, i * 680, y);
    }
    g.dispose();
    ImageIO.write(image, "png", file);
  }

  public static BufferedImage createImage(String str, Font font, Integer width, Integer height) {
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
//    Graphics g = image.getGraphics();
    Graphics2D g = image.createGraphics();
    g.setClip(0, 0, width, height);
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.black);
    g.setFont(font);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    Rectangle clip = g.getClipBounds();
    FontMetrics fm = g.getFontMetrics(font);
    int ascent = fm.getAscent();
    int descent = fm.getDescent();
    int y = (clip.height - (ascent + descent)) / 2 + ascent;
    for (int i =0; i < 6; i++) {
      g.drawString(str, i * 680, y);
    }
    g.dispose();
    return image;
  }

  public static BufferedImage create(String text, Font font, Integer width, Integer height) {
    FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
    int fontsWidth = width == null ? getWordWidth(font, text) : width;
    int fontsHeight = height == null ? metrics.getHeight() : height;
    BufferedImage image = new BufferedImage(fontsWidth, fontsHeight, BufferedImage.TYPE_INT_BGR);
    Graphics2D graphics = image.createGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    graphics.setFont(font);
    graphics.setColor(Color.BLACK);
    graphics.drawString(text, 0, metrics.getAscent());
    graphics.dispose();
    return image;
  }

  public static BufferedImage createAtRatio(String text, Font font, Integer width, Integer height) {
    FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
    int fontsWidth = width == null ? getWordWidth(font, text) : width;
    int fontsHeight = height == null ? metrics.getHeight() : height;
    BufferedImage image = new BufferedImage(fontsWidth, fontsHeight, BufferedImage.TYPE_INT_BGR);
    Graphics2D graphics = image.createGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    graphics.setFont(font);
    graphics.setColor(Color.BLACK);
    int x = Float.valueOf(getRatio(image.getWidth(), getWordWidth(font, text))).intValue();
//    int y = Float.valueOf(getRatio(image.getHeight(), font.getStyle())).intValue();
    graphics.drawString(text, x, metrics.getAscent());
    graphics.dispose();
    return image;
  }


}
