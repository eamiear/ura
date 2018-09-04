package com.ura.art.config;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DrawerUtils {
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
    return image;
  }
}
