package com.xxxx.seckill.util;


import org.apache.commons.codec.digest.DigestUtils;

/*
 *@program:seckill-demo
 *@author: Tomasonlee
 *@Time: 2021/1/18  10:43
 */
public class Md5Util {
    public static String md5(String args) {
        return DigestUtils.md5Hex(args);
    }
    private static final String salt="1a2b3c4d";

    public static String inputPassToFormPass(String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    //二次加密  后端密码到数据库密码
    public static String fromPassToDBPass(String formPass,String salt){
        String str = ""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass = inputPassToFormPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass,salt);
        return dbPass;
    }
    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(fromPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9","1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }

}