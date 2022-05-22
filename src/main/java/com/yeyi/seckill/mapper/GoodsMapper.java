package com.yeyi.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeyi.seckill.entity.Goods;
import com.yeyi.seckill.vo.GoodsVo;

import java.util.List;

/**
 * 商品表 Mapper 接口
 *
 * @author 作者
 * @date 2022-05-21
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoById(long goodsId);
}
