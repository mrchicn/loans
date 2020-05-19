package com.wjl.loans.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: 念迟 & https://www.mrchi.cn
 * @creed: 夕颜几度香散尽, 自古多情空念迟
 * @date: 2020/5/7 18:27
 * @project: ${ProjectNAME}
 * @description  传入字符串进行 MD5 加密
 */
public class MD5Util {

    public static String getmd5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

}