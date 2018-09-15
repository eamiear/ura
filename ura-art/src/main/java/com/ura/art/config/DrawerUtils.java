package com.ura.art.config;

import com.ura.art.filter.ImageAlphaFilter;
import com.ura.common.utils.HttpUtil;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.NumberUtils;
import sun.awt.image.ToolkitImage;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DrawerUtils {
  private static Logger logger = LoggerFactory.getLogger(DrawerUtils.class);

  private static int color_range = 220;//色差范围0~255
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
//    logger.info("suffix  ==== " + suffix);
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

  public static void transparent(BufferedImage bi, String targetFile) throws Exception{
    int width = bi.getWidth();
    int height = bi.getHeight();

    ImageIcon imageIcon = new ImageIcon(bi);

//    BufferedImage bufferedImage= new BufferedImage(widh, height, BufferedImage.TYPE_4BYTE_ABGR);
    BufferedImage bufferedImage= new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
    g.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());

    int alpha = 100;
    // 外层遍历是Y轴的像素
    for (int y = bufferedImage.getMinY(); y < bufferedImage.getHeight(); y++) {
      // 内层遍历是X轴的像素
      for (int x = bufferedImage.getMinX(); x < bufferedImage.getWidth(); x++) {
        int rgb = bufferedImage.getRGB(x, y);
        // #AARRGGBB 最前两位为透明度
        rgb = ((alpha + 1) << 24) | (rgb & 0x00ffffff);
        bufferedImage.setRGB(x, y, rgb);
      }
    }
//    g.drawImage(bufferedImage, 0, 0, null);
    g.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
    ImageIO.write(bufferedImage, targetFile.split("\\.")[1], new File(targetFile));
  }

  public static BufferedImage transparentImage(BufferedImage bi, int alpha) throws Exception{
    BufferedImage bufferedImage= new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
    ImageFilter imageFilter = new ImageAlphaFilter(alpha);
    FilteredImageSource fis = new FilteredImageSource(bi.getSource(),imageFilter);
    Image image = Toolkit.getDefaultToolkit().createImage(fis);
    g.drawImage(image, 0, 0, null);
    g.dispose();
    return bufferedImage;
  }

  /**
   *
   * @param bi
   * @param colorRange
   * @param alpha
   * @return
   */
  public static BufferedImage transparentImage(BufferedImage bi, int colorRange, int alpha) {
    ImageIcon imageIcon = new ImageIcon(bi);
    BufferedImage bufferedImage= new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
    g.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());

    int _alpha = 0;
    for (int y = bufferedImage.getMinY(); y < bufferedImage.getHeight(); y++) {
      for (int x = bufferedImage.getMinX(); x < bufferedImage.getWidth(); x++) {
        int rgb = bufferedImage.getRGB(x, y);
        if (colorInRange(rgb, colorRange)) {
          _alpha = 0;
        } else {
          _alpha = 255;
        }
        rgb = (_alpha << 24) | (rgb & 0x00ffffff);
        bufferedImage.setRGB(x, y, rgb);
      }
    }
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
    g.dispose();
    return bufferedImage;
  }
  public static void alpha(BufferedImage bi, String targetFile) throws Exception{
    BufferedImage bufferedImage= new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
    ImageFilter imageFilter = new ImageAlphaFilter(255);
    FilteredImageSource fis = new FilteredImageSource(bi.getSource(),imageFilter);
    Image image = Toolkit.getDefaultToolkit().createImage(fis);
    g.drawImage(image, 0, 0, null);
    g.dispose();
//    BufferedImage img = ((ToolkitImage)Toolkit.getDefaultToolkit().createImage(fis)).getBufferedImage();
    ImageIO.write(bufferedImage, targetFile.split("\\.")[1], new File(targetFile));
  }

  public static void alphaImage(BufferedImage bi, String targetFile) throws Exception{
    int width = bi.getWidth();
    int height = bi.getHeight();

    ImageIcon imageIcon = new ImageIcon(bi);

//    BufferedImage bufferedImage= new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    BufferedImage bufferedImage= new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
//    g.drawImage(imageIcon.getImage(), 0, 0, null);
    g.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());

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
//    g.drawImage(bufferedImage, 0, 0, null);
    g.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
    ImageIO.write(bufferedImage, targetFile.split("\\.")[1], new File(targetFile));
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

  /**
   *
   * @param color
   * @param colorRange
   * @return
   */
  public static boolean colorInRange(int color, int colorRange){
    int red = (color & 0xff0000) >> 16;
    int green = (color & 0x00ff00) >> 8;
    int blue = (color & 0x0000ff);
    return (red >= colorRange && green >= colorRange && blue >= colorRange);
  }

  public int filterRGB(int x, int y, int rgb) {
    DirectColorModel dcm = (DirectColorModel) ColorModel.getRGBdefault();
    int red = dcm.getRed(rgb);
    int green = dcm.getGreen(rgb);
    int blue = dcm.getBlue(rgb);
    int alp = dcm.getAlpha(rgb);
    int alpha = 255;
    if (red == 255 && green == 255 && blue == 255) {
      alpha = 0;
    } else {
      alpha = 255;
    }
    return alpha << 24 | red << 16 | green << 8 | blue;
  }

  public static BufferedImage alpha1(BufferedImage bi){
//    int color = bi.getRGB(0, 0);
    int color = Color.WHITE.getRGB();
    Image image = makeColorTransparent(bi, new Color(color));
    return imageToBufferedImage(image);

  }

  public static BufferedImage imageToBufferedImage(Image image){
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = bufferedImage.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(image, 0, 0, null);
    g.dispose();
    return bufferedImage;
  }

  /**
   * Make provided image transparent wherever color matches the provided color.
   *
   * @param bi BufferedImage whose color will be made transparent.
   * @param color Color in provided image which will be made transparent.
   * @return Image with transparency applied.
   */
  public static Image makeColorTransparent(BufferedImage bi, Color color){
    ImageFilter filter = new RGBImageFilter() {
      // the color we are looking for (white)... Alpha bits are set to opaque
//      int markerRGB = color.getRGB() | 0xFFFFFFFF;
      int markerRGB = color.getRGB() | 0xFF000000;
      @Override
      public int filterRGB(int x, int y, int rgb) {
        if ((rgb | 0xFF000000) == markerRGB){
          // Mark the alpha bits as zero - transparent
          return 0x00FFFFFF & rgb;
        } else {
          return rgb;
        }
      }
    };
    ImageProducer ip = new FilteredImageSource(bi.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
  }

  /**
   * 图片缩放或放大
   * @param bi
   * @param width
   * @param height
   * @return
   */
  public static BufferedImage scaleImage(BufferedImage bi, int width, int height) {
    boolean hasAlpha = bi.getColorModel().hasAlpha();
    int thumbWidth = width;
    int thumbHeight = height;
    double thumbRatio = (double) width / (double)height;
    double imageRatio = (double)bi.getWidth() / (double) bi.getHeight();
    if (thumbRatio < imageRatio) {
      thumbHeight = (int)(thumbWidth / imageRatio);
    } else {
      thumbWidth = (int)(thumbHeight * imageRatio);
    }

    BufferedImage thumb;
    if (hasAlpha) {
      thumb = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_ARGB);
    } else {
      thumb = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
    }
    Graphics2D g = thumb.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(bi, 0, 0, thumbWidth, thumbHeight, null);
    return thumb;
  }
}


