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

    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
}
