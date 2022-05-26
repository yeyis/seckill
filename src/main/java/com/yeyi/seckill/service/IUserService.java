package com.yeyi.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.vo.LoginVo;
import com.yeyi.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *
 * @author 作者
 * @date 2022-05-17
 */
public interface IUserService extends IService<User> {
    /**做登陆操作
     * @description:
     * @author: yeyi@ustc
     * @date: 2022/5/26 14:28
     * @param: [loginVo, request, response]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
    /**
     * @description:修改密码
     * @author: yeyi@ustc
     * @date: 2022/5/26 14:27
     * @param: [userTicket, password, request, response]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    RespBean updatePassword(String userTicket, String password, HttpServletRequest request, HttpServletResponse response);
}
