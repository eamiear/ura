/**
 * @author eamiear
 * @date 2018/9/13 14:17
 */

package com.ura.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
}
