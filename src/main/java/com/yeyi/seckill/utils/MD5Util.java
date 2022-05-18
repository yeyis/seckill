package com.yeyi.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @BelongsProject: seckill
 * @BelongsPackage: com.yeyi.seckill.utils
 * @Author: yeyi
 * @CreateTime: 2022-05-17  14:08
 * @Description: MD5加密工具类
 * @Version: 1.0
 */
public class MD5Util {
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    private static final String salt = "1a2b3c4d";
    /**
     * @description:第一次加密
     * @author: yeyi@ustc
     * @date: 2022/5/17 14:10
     * @param: [inputPass]
     * @return: java.lang.String
     **/
    public static String inputPassToFromPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * @description:第二次加密
     * @author: yeyi@ustc
     * @date: 2022/5/17 14:11
     * @param: [formPass, salt]
     * @return: java.lang.String
     **/
    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        //d3b1294a61a07da9b49b6e22b2cbd7f9
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }
}

