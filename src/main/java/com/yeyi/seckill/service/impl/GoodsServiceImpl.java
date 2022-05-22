package com.yeyi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeyi.seckill.entity.Goods;
import com.yeyi.seckill.mapper.GoodsMapper;
import com.yeyi.seckill.service.IGoodsService;
import com.yeyi.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品表
 *
 * @author 作者
 * @date 2022-05-21
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @description:获取商品列表
     * @author: yeyi@ustc
     * @date: 2022/5/21 15:18
     * @param: []
     * @return: java.util.List<com.yeyi.seckill.entity.Goods>
     **/
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }

    @Override
    public GoodsVo findGoodsVoByGoodsId(long goodsId) {
        return goodsMapper.findGoodsVoById(goodsId);
    }
}
