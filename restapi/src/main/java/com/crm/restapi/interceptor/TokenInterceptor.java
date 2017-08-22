package com.crm.restapi.interceptor;

import com.crm.restapi.annotation.Token;
import com.crm.restapi.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/18.
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Value("${token.crm.secret}")
    private String secret;
    @Value("${token.crm.heard}")
    private String heard;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token tokenAnnotaion = method.getAnnotation(Token.class);
            if (tokenAnnotaion == null) {
                return true;
            } else {
                String token = request.getHeader(heard);
                if (token == null || token.isEmpty()) {
                    String ip = request.getRemoteAddr();
                    String uri = request.getRequestURI();
                    throw new Exception("缺少token参数, " + ip + ", 请求了：" + uri);
                }

                    Claims claims = JWTUtil.parseJWT(token, secret);
                    if(claims == null){
                        throw new Exception("解析token失败。");
                    }

            }
        }
        return true;
    }
}