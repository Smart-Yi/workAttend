package com.program.common.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 匡小菜 on 2017/6/27.
 */
public class SecurityUtils {

    public static String encryptyPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        BASE64Encoder base64Encoder = new BASE64Encoder();

        String result = base64Encoder.encode(messageDigest.digest(password.getBytes("utf-8")));

        return result ;
    }

    public static boolean checkPassword (String inputPwd , String dbPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String md5InputPwd = encryptyPassword(inputPwd) ;

        return  md5InputPwd.equals(dbPwd) ;
    }
}
