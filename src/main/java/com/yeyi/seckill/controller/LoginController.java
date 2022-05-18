package com.yeyi.seckill.controller;

import com.yeyi.seckill.service.IUserService;
import com.yeyi.seckill.vo.LoginVo;
import com.yeyi.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @BelongsProject: seckill
 * @BelongsPackage: com.yeyi.seckill.controller
 * @Author: yeyi
 * @CreateTime: 2022-05-17  15:41
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private IUserService userService;
    /**
     * @description:跳转登录页面
     * @author: yeyi@ustc
     * @date: 2022/5/17 15:43
     * @param: []
     * @return: java.lang.String
     **/
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
    /**
     * @description:登录功能
     * @author: yeyi@ustc
     * @date: 2022/5/17 21:26
     * @param: [loginVo]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo) {
        return userService.doLogin(loginVo);
    }
}

