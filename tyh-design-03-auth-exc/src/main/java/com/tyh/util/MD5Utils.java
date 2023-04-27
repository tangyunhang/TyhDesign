package com.tyh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: MD5Utils
 * @Author: 青衣醉
 * @Date: 2023/4/23 5:17 下午
 */
public class MD5Utils {
    public static String md5(String input){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace ();
        }
        md.update(input.getBytes());
        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
