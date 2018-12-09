/**
 * @author eamiear
 * @date 2018/9/13 14:17
 */

package com.ura.common.utils;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.gif.GIFImageReaderSpi;
import com.ura.common.utils.image.AnimatedGifEncoder;
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.stream.FileImageInputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.Base64;

public class ImageUtils {
  private static String ascii = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\\\"^`'.";
  private static String base = "@#&$%*o!;.";
  private static final int IMAGE_TYPE = BufferedImage.TYPE_INT_RGB;

  /**
   * 将图片转为字节数组
   *
   * @param imagePath 图片路径
   * @return
   * @throws Exception
   */
  public static byte[] image2Bytes(String imagePath) throws Exception {
    FileInputStream fin = new FileInputStream(new File(imagePath));
    byte[] bytes = new byte[fin.available()];
    fin.read(bytes);
    fin.close();
    return bytes;
  }

  /**
   * 将图片字节数组保存为图片
   *
   * @param buffer     图片字节数组
   * @param targetPath 图片保存路径
   * @throws Exception
   */
  public static void byte2Image(byte[] buffer, String targetPath) throws Exception {
    FileOutputStream fos = new FileOutputStream(targetPath);
    fos.write(buffer);
    fos.close();
  }

  /**
   * 将图片转为base64字符串
   *
   * @param bi BufferedImage
   * @return
   * @throws Exception
   */
  public static String bufferedImageToBase64Str(BufferedImage bi) throws Exception {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageIO.write(bi, "gif", os);
//        byte[] bytes = os.toByteArray();
//        BASE64Encoder encoder = new BASE64Encoder();
//        String base64 = encoder.encodeBuffer(bytes).trim();
//        base64.replaceAll("\n", "").replaceAll("\r", "");
    String base64 = Base64.getEncoder().encodeToString(os.toByteArray());
    return base64;
  }

  /**
   * @param bi     BufferedImage
   * @param format 图片类型 png...
   * @return {InputStream}
   * @throws Exception
   */
  public static InputStream bufferedImageToInputStream(BufferedImage bi, String format) throws Exception {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageIO.write(bi, format, os);
    InputStream is = new ByteArrayInputStream(os.toByteArray());
    return is;
  }

  /**
   * 图片等比缩放
   *
   * @param source
   * @param resizeWidth
   * @param resizeHeight
   * @return
   */
  public static BufferedImage resize(BufferedImage source, int resizeWidth, int resizeHeight) {
    int type = source.getType();
    BufferedImage target = null;
    double sx = (double) resizeWidth / source.getWidth();
    double sy = (double) resizeHeight / source.getHeight();
    // 等比
    if (sx < sy) {
      sx = sy;
      resizeWidth = (int) (sx * source.getWidth());
    } else {
      sy = sx;
      resizeHeight = (int) (sy * source.getHeight());
    }
    if (type == BufferedImage.TYPE_CUSTOM) {
      ColorModel colorModel = source.getColorModel();
      WritableRaster raster = colorModel.createCompatibleWritableRaster(resizeWidth, resizeHeight);
      boolean alphaPremultiplied = colorModel.isAlphaPremultiplied();
      target = new BufferedImage(colorModel, raster, alphaPremultiplied, null);
    } else {
      target = new BufferedImage(resizeWidth, resizeHeight, type);
    }
    Graphics2D g = target.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
    g.dispose();
    return target;
  }

  /**
   * 实现图像的等比缩放和缩放后的截取, 处理成功返回true, 否则返回false
   *
   * @param inFilePath  要截取文件的路径
   * @param outFilePath 截取后输出的路径
   * @param width       要截取宽度
   * @param height      要截取的高度
   * @return
   */
  public static boolean compress(String inFilePath, String outFilePath, int width, int height) {
    boolean ret = false;
    File file = new File(inFilePath);
    File saveFile = new File(outFilePath);
    InputStream in = null;
    try {
      in = new FileInputStream(file);
      ret = compress(in, saveFile, width, height);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      ret = false;
    } finally {
      if (null != in) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return ret;
  }

  /**
   * 实现图像的等比缩放和缩放后的截取, 处理成功返回true, 否则返回false
   *
   * @param in       图片输入流
   * @param saveFile 压缩后的图片输出流
   * @param width    要截取宽度
   * @param height   要截取的高度
   */
  public static boolean compress(InputStream in, File saveFile, int width, int height) {
    BufferedImage srcImage = null;
    try {
      srcImage = ImageIO.read(in);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    if (width > 0 || height > 0) {
      int sw = srcImage.getWidth();
      int sh = srcImage.getHeight();
      if (sw > width && sh > height) {
        srcImage = resize(srcImage, width, height);
      } else {// 原图小于要缩放的图片大小，直接复制图片
        String fileName = saveFile.getName();
        String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
        try {
          ImageIO.write(srcImage, formatName, saveFile);
        } catch (IOException e) {
          e.printStackTrace();
          return false;
        }
        return true;
      }
    }
    //
    int w = srcImage.getWidth();
    int h = srcImage.getHeight();
    // 如果缩放后的图像和要求的图像宽度一样，就对缩放的图像的高度进行截取
    if (w == width) {
      int x = 0;
      int y = h / 2 - height / 2;
      try {
        saveSubImage(srcImage, new Rectangle(x, y, width, height), saveFile);
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
    } else if (h == height) {
      // 否则如果是缩放后的图像的高度和要求的图像高度一样，就对缩放后的图像的宽度进行截取
      int x = w / 2 - width / 2;
      int y = 0;
      try {
        saveSubImage(srcImage, new Rectangle(x, y, width, height), saveFile);
      } catch (IOException ex) {
        ex.printStackTrace();
        return false;
      }
    }
    return true;
  }

  /**
   * 实现图像的等比缩放和缩放后的截取, 处理成功返回true, 否则返回false
   *
   * @param in         图片输入流
   * @param saveFile   压缩后的图片输出流
   * @param proportion 压缩比
   * @return
   */
  public static boolean compress(InputStream in, File saveFile, int proportion) {
    if (null == in || null == saveFile || proportion < 1) {
      return false;
    }
    BufferedImage srcImage = null;
    try {
      srcImage = ImageIO.read(in);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    // 原图的大小
    int width = srcImage.getWidth() / proportion;
    int height = srcImage.getHeight() / proportion;
    srcImage = resize(srcImage, width, height);

    // 缩放后的图像的宽和高
    int w = srcImage.getWidth();
    int h = srcImage.getHeight();
    // 如果缩放后的图像和要求的图像宽度一样，就对缩放的图像的高度进行截取
    if (w == width) {
      // 计算X轴坐标
      int x = 0;
      int y = h / 2 - height / 2;
      try {
        saveSubImage(srcImage, new Rectangle(x, y, width, height), saveFile);
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
    }
    // 否则如果是缩放后的图像的高度和要求的图像高度一样，就对缩放后的图像的宽度进行截取
    else if (h == height) {
      // 计算X轴坐标
      int x = w / 2 - width / 2;
      int y = 0;
      try {
        saveSubImage(srcImage, new Rectangle(x, y, width, height), saveFile);
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }

  /**
   * 实现缩放后的截图
   *
   * @param image          缩放后的图像
   * @param subImageBounds 要截取的子图的范围
   * @param subImageFile   要保存的文件
   * @throws IOException
   */
  private static void saveSubImage(BufferedImage image, Rectangle subImageBounds, File subImageFile) throws IOException {
    if (subImageBounds.x < 0 || subImageBounds.y < 0
      || subImageBounds.width - subImageBounds.x > image.getWidth()
      || subImageBounds.height - subImageBounds.y > image.getHeight()) {
      return;
    }
    BufferedImage subImage = image.getSubimage(subImageBounds.x, subImageBounds.y, subImageBounds.width, subImageBounds.height);
    String fileName = subImageFile.getName();
    String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
    ImageIO.write(subImage, formatName, subImageFile);
  }


  public static char toChar(int g) {
    if (g <= 30) {
      return '#';
    } else if (g > 30 && g <= 60) {
      return '&';
    } else if (g > 60 && g <= 120) {
      return '$';
    } else if (g > 120 && g <= 150) {
      return '*';
    } else if (g > 150 && g <= 180) {
      return 'o';
    } else if (g > 180 && g <= 210) {
      return '!';
    } else if (g > 210 && g <= 240) {
      return ';';
    } else {
      return ' ';
    }
  }

  /**
   * 图片转字符图片
   *
   * @param imagePath 图片路径
   * @param txtPath   图片路径
   * @throws IOException
   */
  public static void image2ascii(String imagePath, String txtPath) throws IOException {
    BufferedImage image = resize(ImageIO.read(new File(imagePath)), 150, 150);
    image2ascii(image, txtPath);
  }

  /**
   * 图片转字符图片
   *
   * @param bi       BufferedImage图片
   * @param savePath 文本存放路径
   * @throws IOException
   */
  public static void image2ascii(BufferedImage bi, String savePath) throws IOException {
    try {
      int width = bi.getWidth();
      int height = bi.getHeight();
      boolean flag = false;
      String result = "";
      for (int i = 0; i < height; i += 2) {
        for (int j = 0; j < width; j++) {
          int pixel = bi.getRGB(j, i);
          int red = (pixel & 0xff0000) >> 16;
          int green = (pixel & 0xff00) >> 8;
          int blue = (pixel & 0xff);
          float gray = 0.299f * red + 0.578f * green + 0.114f * blue;
          int index = Math.round(gray * (base.length() + 1) / 255);
          result += index >= base.length() ? " " : String.valueOf(base.charAt(index));
        }
        result += "\r\n";
      }
      flag = writeTxtFile(result, savePath);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 字符保存到txt文件中
   *
   * @param imageStr 图片ascii字符串
   * @param txtPath  图片保存路径
   * @return
   * @throws Exception
   */
  private static boolean writeTxtFile(String imageStr, String txtPath) throws Exception {
    boolean flag = false;
    String fileInputFile = imageStr;
    String temp = "";
    FileInputStream fis = null;
    InputStreamReader isr = null;
    BufferedReader br = null;

    FileOutputStream fos = null;
    PrintWriter pw = null;
    try {
      File file = new File(txtPath);
      if (!file.exists()) {
        file.createNewFile();
      }
      fis = new FileInputStream(file);
      isr = new InputStreamReader(fis);
      br = new BufferedReader(isr);
      StringBuffer buf = new StringBuffer();
      for (int j = 1; (temp = br.readLine()) != null; j++) {
        buf = buf.append(temp);
      }
      buf.append(fileInputFile);
      fos = new FileOutputStream(file);
      pw = new PrintWriter(fos);
      pw.write(buf.toString().toCharArray());
      pw.flush();
      flag = true;
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (pw != null) {
        pw.close();
      }
      if (fos != null) {
        fos.close();
      }
      if (br != null) {
        br.close();
      }
      if (isr != null) {
        isr.close();
      }
      if (fis != null) {
        fis.close();
      }
    }
    return flag;
  }

  /**
   * 图片转字符图片
   *
   * @param imagePath
   * @param txtPath   文本存放路径
   * @throws IOException
   */
  public static void gifImage2ascill(String imagePath, String txtPath) throws IOException {
    File imageFile = new File(imagePath);
    FileImageInputStream fis = new FileImageInputStream(imageFile);
    ImageReaderSpi readerSpi = new GIFImageReaderSpi();
    GIFImageReader gifImageReader = new GIFImageReader(readerSpi);
    gifImageReader.setInput(fis);
    int num = gifImageReader.getNumImages(true);
    BufferedImage[] bufferedImages = new BufferedImage[num];
    for (int i = 0; i < num; i++) {
      BufferedImage bi = gifImageReader.read(i);
      //每一帧都保存为图片
      bufferedImages[i] = txtToImage(bi, txtPath + "out" + i + ".jpeg");
    }
    jpgToGif(bufferedImages, txtPath + imagePath.substring(imagePath.length() - 6) + "outGif.gif", 200);
  }

  /**
   * 图片转字符再保存为图片
   *
   * @param bi
   * @param outputPath
   * @return
   */
  public static BufferedImage txtToImage(BufferedImage bi, String outputPath) {
    File imageFile = new File(outputPath);
    if (!imageFile.exists()) {
      try {
        imageFile.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    int width = bi.getWidth();
    int height = bi.getHeight();
    int minx = bi.getMinX();
    int miny = bi.getMinY();
    int speed = 7;
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = createGraphics(bufferedImage, width, height, speed);
    //图片中文本行高
    final int Y_LINEHEIGHT = speed;
    int lineNum = 1;
    for (int i = miny; i < height; i += speed) {
      for (int j = minx; j < width; j += speed) {
        int pixel = bi.getRGB(j, i);
        int red = (pixel & 0xff0000) >> 16;
        int green = (pixel & 0xff00) >> 8;
        int blue = (pixel & 0xff);
        float gray = 0.299f * red + 0.578f * green + 0.114f * blue;
        int index = Math.round(gray * (base.length() + 1) / 255);
        String c = index >= base.length() ? " " : String.valueOf(base.charAt(index));
        g.drawString(String.valueOf(c), j, i);
      }
      lineNum++;
    }
    g.dispose();
    FileOutputStream fos;
    try {
      fos = new FileOutputStream(imageFile);
      JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
//      OutputStream out = encoder.getOutputStream();
//      BASE64Decoder base64Decoder = new BASE64Decoder();
      encoder.encode(bufferedImage);
      fos.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (ImageFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return bufferedImage;
  }

  /**
   * 图片转字符再保存为图片 只返回图片的base64
   *
   * @param bi
   * @return
   */
  public static String txtToImageByBase64(BufferedImage bi) {
    final String base = "@#&$%*o!;.";
    int width = bi.getWidth();
    int height = bi.getHeight();
    int minx = bi.getMinX();
    int miny = bi.getMinY();
    int speed = 7;
    BufferedImage bufferedImage = new BufferedImage(width, height, IMAGE_TYPE);
    Graphics g = createGraphics(bufferedImage, width, height, speed);
    int lineNum = 1;
    for (int i = miny; i < height; i += speed) {
      for (int j = minx; j < width; j += speed) {
        int pixel = bi.getRGB(j, i);
        int red = (pixel & 0xff0000) >> 16;
        int green = (pixel & 0xff00) >> 8;
        int blue = (pixel & 0xff);
        float gray = 0.299f * red + 0.578f * green + 0.114f * blue;
        int index = Math.round(gray * (base.length() + 1) / 255);
        String c = index >= base.length() ? " " : String.valueOf(base.charAt(index));
        g.drawString(String.valueOf(c), j, i);
      }
      lineNum++;
    }
    g.dispose();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try {
      ImageIO.write(bufferedImage, "jpg", out);
      String base64 = Base64Utils.encode(out.toByteArray()).toString();
      return base64;
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != out) {
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  /**
   * jpg转gif方法
   *
   * @param bufferedImages
   * @param newPic
   * @param playTime
   */
  private static void jpgToGif(BufferedImage[] bufferedImages, String newPic, int playTime) {
    try {
      AnimatedGifEncoder encoder = new AnimatedGifEncoder();
      encoder.setRepeat(0);
      encoder.start(newPic);
      for (int i = 0; i < bufferedImages.length; i++) {
        encoder.setDelay(playTime);
        encoder.addFrame(bufferedImages[i]);
      }
      encoder.finish();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 画板默认一些参数设置
   *
   * @param image  图片
   * @param width
   * @param height
   * @param size   字体大小
   * @return
   */
  private static Graphics createGraphics(BufferedImage image, int width, int height, int size) {
    Graphics g = image.createGraphics();
    g.setColor(null);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.BLACK);
    g.setFont(new Font("微软雅黑", Font.PLAIN, size));
    return g;
  }
}
