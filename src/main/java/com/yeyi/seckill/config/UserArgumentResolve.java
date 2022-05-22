package com.yeyi.seckill.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.utils.CookieUtil;
import org.apache.coyote.Response;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

/**
 * @BelongsProject: seckill-demo1
 * @BelongsPackage: com.yeyi.seckill.config
 * @Author: yeyi
 * @CreateTime: 2022-05-21  10:20
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class UserArgumentResolve implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpSession session = request.getSession();
        String ticket = CookieUtil.getCookieValue(request,"userTicket");
        System.out.println(ticket);
        if(StringUtils.isEmpty(ticket)){
            return null;
        }
        User user = (User) session.getAttribute(ticket);
        return user;
    }
}

