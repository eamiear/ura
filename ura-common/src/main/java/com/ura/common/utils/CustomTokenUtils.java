/**
 * @author eamiear
 * @date 2018/8/10 15:48
 */

package com.ura.common.utils;

import com.ura.common.exception.URAException;

import java.security.MessageDigest;
import java.util.UUID;

public class CustomTokenUtils {

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String generateToken() {
        return generateToken(UUID.randomUUID().toString());
    }

    public static String generateToken(String code) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(code.getBytes());
            byte[] digest = messageDigest.digest();
            return toHexString(digest);
        } catch (Exception e) {
            throw new URAException("生成token 失败", e);
        }
    }

    public static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(data.length * 2);
        for (byte b : data) {
            builder.append(hexCode[(b >> 4) & 0xF]);
            builder.append(hexCode[(b & 0xF)]);
        }
        return builder.toString();
    }
}
