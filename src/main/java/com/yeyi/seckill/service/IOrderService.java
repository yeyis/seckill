package com.yeyi.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeyi.seckill.entity.Order;
import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.vo.GoodsVo;

/**
 * 
 *
 * @author 作者
 * @date 2022-05-21
 */
public interface IOrderService extends IService<Order> {
    /**
     * @description:创建订单表
     * @author: yeyi@ustc
     * @date: 2022/5/23 22:52
     * @param: [user, goods]
     * @return: com.yeyi.seckill.entity.Order
     **/
    Order seckill(User user, GoodsVo goods);
}
