/**
 * @author eamiear
 * @date 2018/9/13 9:31
 */

package com.ura.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamUtils {
    public static byte[] stream2bytes(InputStream is) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;//每次读取的字符串长度，如果为-1，代表全部读取完毕
        while ((len = is.read(buffer)) != -1) {//使用一个输入流从buffer里把数据读取出来
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outputStream.write(buffer, 0, len);
        }
        is.close();
        return outputStream.toByteArray();
    }
    public static String byteArrayToString(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        return new String(byteArray);
    }

    public static byte[] StringToByteArray(String string) {
        if (string == null) {
            return null;
        }
        return string.getBytes();
    }
}
