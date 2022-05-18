package com.yeyi.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: seckill
 * @BelongsPackage: com.yeyi.seckill.vo
 * @Author: yeyi
 * @CreateTime: 2022-05-17  15:51
 * @Description: 公共返回对象
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;
    /**
     * @description:成功返回结果
     * @author: yeyi@ustc
     * @date: 2022/5/17 16:01
     * @param: []
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(),null);
    }
    /**
     * @description:成功返回结果
     * @author: yeyi@ustc
     * @date: 2022/5/17 16:06
     * @param: [obj]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    public static RespBean success(Object obj){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(),obj);
    }
    /**
     * @description:失败返回结果
     * @author: yeyi@ustc
     * @date: 2022/5/17 16:09
     * @param: [respBeanEnum]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    public static RespBean error(RespBeanEnum respBeanEnum){
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }
    /**
     * @description:失败返回结果
     * @author: yeyi@ustc
     * @date: 2022/5/17 16:09
     * @param: [respBeanEnum, obj]
     * @return: com.yeyi.seckill.vo.RespBean
     **/
    public static RespBean error(RespBeanEnum respBeanEnum,Object obj){
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), obj);
    }
}

