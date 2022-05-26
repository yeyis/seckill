package com.yeyi.seckill.controller;

import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.vo.RespBean;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 *
 * @author 作者
 * @date 2022-05-17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * @description:用户信息压测
     * @author: yeyi@ustc
     * @date: 2022/5/25 21:47
     * @param:
     * @return:
     **/

    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }
}
