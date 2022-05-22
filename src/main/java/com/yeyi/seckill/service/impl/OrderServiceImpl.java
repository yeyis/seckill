package com.yeyi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeyi.seckill.entity.Order;
import com.yeyi.seckill.mapper.OrderMapper;
import com.yeyi.seckill.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author 作者
 * @date 2022-05-21
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
