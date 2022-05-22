package com.yeyi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeyi.seckill.entity.SeckillOrder;
import com.yeyi.seckill.mapper.SeckillOrderMapper;
import com.yeyi.seckill.service.ISeckillOrderService;
import org.springframework.stereotype.Service;

/**
 * 秒杀订单表
 *
 * @author 作者
 * @date 2022-05-21
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {

}
