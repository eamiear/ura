/**
 * @author eamiear
 * @date 2018/9/13 14:17
 */

package com.ura.common.utils;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
}
