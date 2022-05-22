package com.yeyi.seckill.controller;

import com.example.seckilldemo.config.AccessLimit;
import com.example.seckilldemo.entity.TOrder;
import com.example.seckilldemo.entity.TSeckillOrder;
import com.example.seckilldemo.entity.TUser;
import com.example.seckilldemo.exception.GlobalException;
import com.example.seckilldemo.rabbitmq.MQSender;
import com.example.seckilldemo.service.ITGoodsService;
import com.example.seckilldemo.service.ITOrderService;
import com.example.seckilldemo.service.ITSeckillOrderService;
import com.example.seckilldemo.utils.JsonUtil;
import com.example.seckilldemo.vo.GoodsVo;
import com.example.seckilldemo.vo.RespBean;
import com.example.seckilldemo.vo.RespBeanEnum;
import com.example.seckilldemo.vo.SeckillMessage;
import com.wf.captcha.ArithmeticCaptcha;
import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.vo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 秒杀
 *
 * @author: yeyi@ustc
 * @date 2022/3/4 11:34 上午
 * @ClassName: SeKillController
 */
@Controller
@RequestMapping("/seckill")
public class SeKillController{


    /**
     * @description:秒杀
     * @author: yeyi@ustc
     * @date: 2022/5/22 11:33
     * @param: [path, user, goodsId]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    @RequestMapping("/doSecKill")
    public String doSecKill(Model model, User user, Long goodsId) {

    }
}
