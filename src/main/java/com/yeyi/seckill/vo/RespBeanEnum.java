package com.yeyi.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @BelongsProject: seckill
 * @BelongsPackage: com.yeyi.seckill.vo
 * @Author: yeyi
 * @CreateTime: 2022-05-17  15:51
 * @Description: TODO
 * @Version: 1.0
 */
@ToString
@AllArgsConstructor
@Getter
public enum RespBeanEnum {
    //通用
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常"),
    //登录模块
    LOGIN_ERROR(500210, "用户名或者密码不正确"),
    MOBILE_ERROR(500211, "手机号码格式不正确"),
    BIND_ERROR(500212, "参数校验异常"),
    MOBILE_NOT_EXIST(500213, "手机号码不存在"),
    PASSWORD_UPDATE_FAIL(500214, "更新密码失败"),
    SESSION_ERROR(500215, "用户SESSION不存在");

    private final Integer code;
    private final String message;

}

