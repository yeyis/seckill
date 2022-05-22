package com.yeyi.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeyi.seckill.entity.Goods;
import com.yeyi.seckill.vo.GoodsVo;

import java.util.List;

/**
 * 商品表
 *
 * @author 作者
 * @date 2022-05-21
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * @description:获取商品列表
     * @author: yeyi@ustc
     * @date: 2022/5/21 15:18
     * @param: []
     * @return: java.util.List<com.yeyi.seckill.entity.Goods>
     **/
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(long goodsId);
}
