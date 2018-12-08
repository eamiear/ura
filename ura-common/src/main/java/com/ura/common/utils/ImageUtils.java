/**
 * @author eamiear
 * @date 2018/9/13 14:17
 */

package com.ura.common.utils;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.Base64;

public class ImageUtils {
    public static byte[] image2Bytes(String imagePath) throws Exception{
        FileInputStream fin = new FileInputStream(new File(imagePath));
        byte[] bytes = new byte[fin.available()];
        fin.read(bytes);
        fin.close();
        return bytes;
    }
    public static void byte2Image(byte[] buffer, String targetPath) throws Exception{
        FileOutputStream fos = new FileOutputStream(targetPath);
        fos.write(buffer);
        fos.close();
    }
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
     *
     * @param bi        BufferedImage
     * @param format    图片类型 png...
     * @return {InputStream}
     * @throws Exception
     */
    public static InputStream bufferedImageToInputStream(BufferedImage bi, String format) throws Exception{
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

  public static boolean compress(String inFilePath, String outFilePath, int width, int height) {
    boolean ret = false;
    File file = new File(inFilePath);
    File saveFile = new File(outFilePath);
    InputStream in = null;
    try {
      in = new FileInputStream(file);
//        ret = compress(compress)
    } catch (Exception e) {

    }
  }

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
    if (w == width) {
      int x = 0;
      int y = h / 2 - height / 2;
      try {

      }
    }
  }

  public static void saveSubImage(BufferedImage image, Rectangle subImageBounds, File subImageFile) throws IOException {

  }
}
