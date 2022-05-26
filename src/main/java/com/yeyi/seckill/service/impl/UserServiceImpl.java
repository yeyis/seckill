package com.yeyi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.exception.GlobalException;
import com.yeyi.seckill.mapper.UserMapper;
import com.yeyi.seckill.service.IUserService;
import com.yeyi.seckill.utils.CookieUtil;
import com.yeyi.seckill.utils.MD5Util;
import com.yeyi.seckill.utils.UUIDUtil;
import com.yeyi.seckill.utils.ValidatorUtil;
import com.yeyi.seckill.vo.LoginVo;
import com.yeyi.seckill.vo.RespBean;
import com.yeyi.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 作者
 * @date 2022-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * @description:登录服务
     * @author: yeyi@ustc
     * @date: 2022/5/17 21:32
     * @param: [loginVo]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
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
        //生成cookie
        String ticket = UUIDUtil.uuid();
        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();
    }

    /**
     * @param userTicket
     * @param password
     * @param request
     * @param response
     * @description:修改密码
     * @author: yeyi@ustc
     * @date: 2022/5/26 14:27
     * @param: [userTicket, password, request, response]
     * @return: com.yeyi.seckill.vo.RespBean
     */
    @Override
    public RespBean updatePassword(String userTicket, String password, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String ticket = CookieUtil.getCookieValue(request, "userTicket");
        User user = (User) session.getAttribute(ticket);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.MOBILE_NOT_EXIST);
        }
        user.setPassword(MD5Util.inputPassToDBPass(password, user.getSalt()));
        int result = userMapper.updateById(user);
        if (1 == result) {
            //删除Redis
            redisTemplate.delete("user:" + userTicket);
            return RespBean.success();
        }
        return RespBean.error(RespBeanEnum.PASSWORD_UPDATE_FAIL);
    }
}

