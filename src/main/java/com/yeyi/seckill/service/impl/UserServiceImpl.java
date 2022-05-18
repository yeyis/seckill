package com.yeyi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.mapper.UserMapper;
import com.yeyi.seckill.service.IUserService;
import com.yeyi.seckill.utils.MD5Util;
import com.yeyi.seckill.utils.ValidatorUtil;
import com.yeyi.seckill.vo.LoginVo;
import com.yeyi.seckill.vo.RespBean;
import com.yeyi.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * @author 作者
 * @date 2022-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @description:登录服务
     * @author: yeyi@ustc
     * @date: 2022/5/17 21:32
     * @param: [loginVo]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    @Override
    public RespBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!ValidatorUtil.isMobile(mobile)) {
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }
        User user = userMapper.selectById(mobile);
        if(null == user){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if(!MD5Util.formPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        return RespBean.success();
    }
}
