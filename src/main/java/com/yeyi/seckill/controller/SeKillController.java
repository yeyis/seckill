package com.yeyi.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeyi.seckill.entity.Order;
import com.yeyi.seckill.entity.SeckillOrder;
import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.service.IGoodsService;
import com.yeyi.seckill.service.IOrderService;
import com.yeyi.seckill.service.ISeckillOrderService;
import com.yeyi.seckill.vo.GoodsVo;
import com.yeyi.seckill.vo.RespBean;
import com.yeyi.seckill.vo.RespBeanEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;
    /**
     * @description:秒杀
     * @author: yeyi@ustc
     * @date: 2022/5/22 11:33
     * @param: [path, user, goodsId]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    @RequestMapping("/doSeckill")
    public String doSecKill(Model model, User user, Long goodsId) {
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if(goods.getGoodsStock() < 1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }
        //判断用户是否有重复的抢购行为
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if(seckillOrder != null){
            model.addAttribute("errmsg", RespBeanEnum.REPEATE_ERROR.getMessage());
            return "secKillFail";
        }
        Order order = orderService.seckill(user,goods);
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);
        return "orderDetail";
    }
}
