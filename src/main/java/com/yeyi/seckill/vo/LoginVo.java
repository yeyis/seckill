package com.yeyi.seckill.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @BelongsProject: seckill
 * @BelongsPackage: com.yeyi.seckill.vo
 * @Author: yeyi
 * @CreateTime: 2022-05-17  21:22
 * @Description: 登陆参数
 * @Version: 1.0
 */
@Data
public class LoginVo {
    @NotNull
    private String mobile;
    @NotNull
    @Length
    private String password;
}

