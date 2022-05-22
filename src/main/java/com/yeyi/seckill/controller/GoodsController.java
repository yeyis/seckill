package com.yeyi.seckill.controller;

import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.service.IGoodsService;
import com.yeyi.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @BelongsProject: seckill-demo1
 * @BelongsPackage: com.yeyi.seckill.controller
 * @Author: yeyi
 * @CreateTime: 2022-05-20  16:24
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toList(Model model, User user){
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        System.out.println("111");
        return "goodsList";
    }

    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable long goodsId){
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        int seckillStatus = 0;
        Date nowDate = new Date();
        //秒杀还未开始
        int remainSeconds = 0;
        if(nowDate.before(startDate)){
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime())/1000);
        }else if(nowDate.after(endDate)){
            //秒杀已经结束
            seckillStatus = 2;
            remainSeconds = -1;
        }else {
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("user",user);
        model.addAttribute("remainSeconds",remainSeconds);
        model.addAttribute("seckillStatus",seckillStatus);
        model.addAttribute("goods",goodsVo);
        return "goodsDetail";
    }
}

