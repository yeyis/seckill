package com.yeyi.seckill.utils;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: seckill
 * @BelongsPackage: com.yeyi.seckill.utils
 * @Author: yeyi
 * @CreateTime: 2022-05-17  21:52
 * @Description: 手机号码校验类
 * @Version: 1.0
 */
public class ValidatorUtil {
    private static final Pattern mobile_patten = Pattern.compile("[1]([3-9])[0-9]{9}$");
    /**
     * @description:校验手机号
     * @author: yeyi@ustc
     * @date: 2022/5/17 21:54
     * @param: [mobile]
     * @return: boolean
     **/
    public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Matcher matcher = mobile_patten.matcher(mobile);
        return matcher.matches();
    }
}

