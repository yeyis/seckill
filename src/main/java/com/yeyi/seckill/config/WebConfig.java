package com.yeyi.seckill.config;

import com.yeyi.seckill.controller.interceptor.GoodsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @BelongsProject: seckill-demo1
 * @BelongsPackage: com.yeyi.seckill.config
 * @Author: yeyi
 * @CreateTime: 2022-05-21  10:18
 * @Description: mvc配置类
 * @Version: 1.0
 */
@Configuration
@ComponentScan("com.yeyi.seckill.controller")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private GoodsInterceptor goodsInterceptor;
    @Autowired
    private UserArgumentResolve userArgumentResolve;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolve);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(goodsInterceptor).addPathPatterns("/goods","/goods/*");
    }
}

