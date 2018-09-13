package com.ura.art.config;

import com.ura.common.utils.HttpUtil;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DrawerUtils {
  private static Logger logger = LoggerFactory.getLogger(DrawerUtils.class);

  private static int color_range = 210;//色差范围0~255
  public static float getRatio(int target, int ref){
    return target / 2 - ref / 2;
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
    int y = Float.valueOf(getRatio(image.getHeight(), font.getSize())).intValue();
    graphics.drawString(text, x / 2, metrics.getAscent());
    graphics.dispose();
    return image;
  }

  /**
   * 截图
   * @param srcFile    源文件
   * @param targetFile 截图文件
   * @param x           截图起点横坐标
   * @param y           截图起点纵坐标
   * @param width       截图宽度
   * @param height      截图高度
   * @throws Exception
   */
  public static void cutLocalImage(String srcFile, String targetFile, int x, int y, int width, int height) throws Exception{
    String suffix = targetFile.split("\\.")[1];
    // 取得图片读入器
    Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(suffix);
    ImageReader reader = readers.next();

    // 取得图片读入流
    InputStream source = new FileInputStream(srcFile);
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis, true);

    ImageReadParam param = reader.getDefaultReadParam();
    Rectangle rect = new Rectangle(x, y, width, height);
    param.setSourceRegion(rect);
    BufferedImage bi = reader.read(0, param);
    ImageIO.write(bi, suffix, new File(targetFile));
  }

  /**
   * @param imageUrl    远程图片url
   * @param targetFile  裁剪图片存放地址
   * @param x           裁剪起点 x坐标
   * @param y           裁剪起点 y坐标
   * @param width       裁剪宽度
   * @param height      裁剪高度
   * @throws Exception
   */
  public static void cutRemoteImage(String imageUrl, String targetFile, int x, int y, int width, int height) throws Exception{
    GetMethod getMethod = null;
    InputStream is = null;
    ImageInputStream iis = null;
    String suffix = targetFile.split("\\.")[1];

    // 取得图片读入器
    Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(suffix);
    ImageReader reader = readers.next();

    Map<String, String> param = new HashMap<String, String>();
    param.put("t", String.valueOf(new Date().getTime()));
    getMethod = HttpUtil.URLGet(imageUrl, param);
    is = getMethod.getResponseBodyAsStream();
    iis = ImageIO.createImageInputStream(is);
    reader.setInput(iis, true);

    ImageReadParam _param = reader.getDefaultReadParam();
    Rectangle rect = new Rectangle(x, y, width, height);
    _param.setSourceRegion(rect);
    BufferedImage bi = reader.read(0, _param);
    ImageIO.write(bi, suffix, new File(targetFile));
//    ImageIO.write(bi, "png", new File("E:\\a.png"));
    if (getMethod != null) {
      getMethod.releaseConnection();
      getMethod = null;
    }
    if (is != null) {
      is.close();
      is = null;
    }
    if (iis != null) {
      iis.close();
      iis = null;
    }
  }

  /**
   *
   * @param imageUrl
   * @param x
   * @param y
   * @param width
   * @param height
   * @return
   * @throws Exception
   */
  public static BufferedImage cutRemoteImage(String imageUrl, int x, int y, int width, int height) throws Exception{
    GetMethod getMethod = null;
    InputStream is = null;
    ImageInputStream iis = null;
    String suffix = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
    if (suffix.contains("?")) {
      suffix = suffix.substring(0, suffix.indexOf("?"));
    }
    suffix = suffix.split("\\.")[1];
    logger.info("suffix  ==== " + suffix);
    // 取得图片读入器
    Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(suffix);
    ImageReader reader = readers.next();

    Map<String, String> param = new HashMap<String, String>();
    param.put("t", String.valueOf(new Date().getTime()));
    getMethod = HttpUtil.URLGet(imageUrl, param);
    is = getMethod.getResponseBodyAsStream();
    iis = ImageIO.createImageInputStream(is);
    reader.setInput(iis, true);

    ImageReadParam _param = reader.getDefaultReadParam();
    Rectangle rect = new Rectangle(x, y, width, height);
    _param.setSourceRegion(rect);
    BufferedImage bi = reader.read(0, _param);
    if (getMethod != null) {
      getMethod.releaseConnection();
      getMethod = null;
    }
    if (is != null) {
      is.close();
      is = null;
    }
    if (iis != null) {
      iis.close();
      iis = null;
    }
    return bi;
  }

  public static void alphaImage(String url, String targetFile) throws Exception{
    BufferedImage image = ImageIO.read(new URL(url));
    int width = image.getWidth();
    int height = image.getHeight();

    ImageIcon imageIcon = new ImageIcon((image));
    BufferedImage bufferedImage= new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
    g.drawImage(imageIcon.getImage(), 0, 0, null);

    int alpha = 0;
    // 外层遍历是Y轴的像素
    for (int y = bufferedImage.getMinY(); y < bufferedImage.getHeight(); y++) {
      // 内层遍历是X轴的像素
      for (int x = bufferedImage.getMinX(); x < bufferedImage.getWidth(); x++) {
        int rgb = bufferedImage.getRGB(x, y);
        if (colorInRange(rgb)) {// 对当前颜色判断是否在指定区间内
          alpha = 0;
        } else {// 设置为不透明
          alpha = 255;
        }
        // #AARRGGBB 最前两位为透明度
        rgb = (alpha << 24) | (rgb & 0x00ffffff);
        bufferedImage.setRGB(x, y, rgb);
      }
    }
    g.drawImage(bufferedImage, 0, 0, null);
    ImageIO.write(bufferedImage, targetFile.split("\\.")[1], new File(targetFile));
  }
  // 判断是背景还是内容
  public static boolean colorInRange(int color) {
    int red = (color & 0xff0000) >> 16;// 获取color(RGB)中R位
    int green = (color & 0x00ff00) >> 8;// 获取color(RGB)中G位
    int blue = (color & 0x0000ff);// 获取color(RGB)中B位
// 通过RGB三分量来判断当前颜色是否在指定的颜色区间内
    if (red >= color_range && green >= color_range && blue >= color_range) {
      return true;
    }
    return false;

  }
}
