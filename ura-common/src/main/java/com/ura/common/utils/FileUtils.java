package com.ura.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileUtils {
  public static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

  public static String getExtend(String filename) {
    return getExtend(filename, "");
  }
  public static String getExtend(String filename, String defExt) {
    if (filename != null && filename.length() > 0) {
      int i = filename.lastIndexOf('.');
      if (i > 0 && i < (filename.length() - 1)) {
        return filename.substring(i + 1).toLowerCase();
      }
    }

    return defExt.toLowerCase();
  }

  public static boolean delete(String filepath) {
    File file = new File(filepath);
    if (!file.exists() || !file.isFile()) {
      logger.info(filepath + "不存在");
      return false;
    }
    return file.delete();
  }

  public static byte[] readFileByBytes(String filepath) throws IOException{
    File file = new File(filepath);
    if (!file.exists()) {
      throw new FileNotFoundException(filepath);
    } else {
      ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
      BufferedInputStream bis = null;

      try {
        bis = new BufferedInputStream(new FileInputStream(file));
        short bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int len;
        while (-1 != (len = bis.read(buffer, 0, bufferSize))) {
          bos.write(buffer, 0, len);
        }
        return bos.toByteArray();
      } finally {
        try {
          if (bis != null) {
            bis.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
        bos.close();
      }
    }
  }

  public static byte[] readStreamByBytes(InputStream is) throws IOException{
    ByteArrayOutputStream bos = new ByteArrayOutputStream(is.available());
    BufferedInputStream bis = null;
    try {
      bis = new BufferedInputStream(is);
      short bufferSize = 1024;
      byte[] buffer = new byte[bufferSize];
      int len;
      while (-1 != (len = bis.read(buffer, 0, bufferSize))) {
        bos.write(buffer, 0, len);
      }
      return bos.toByteArray();
    } finally {
      try {
        if (bis != null) {
          bis.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      bos.close();
    }
  }

  public static void uploadFile(byte[] file, String filepath, String filename) throws Exception{
    File targetFile = new File(filepath);
    if (!targetFile.exists()) {
      targetFile.mkdirs();
    }
    FileOutputStream fos = new FileOutputStream(filepath + filename);
    fos.write(file);
    fos.flush();
    fos.close();
  }
}
