package com.yeyi.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.vo.LoginVo;
import com.yeyi.seckill.vo.RespBean;

/**
 * 
 *
 * @author 作者
 * @date 2022-05-17
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo);
}
