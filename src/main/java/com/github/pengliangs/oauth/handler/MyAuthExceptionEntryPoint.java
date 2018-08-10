package com.github.pengliangs.oauth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pengliangs.oauth.constant.HttpConstant;
import com.github.pengliangs.oauth.response.ResultData;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token校验失败返回信息
 *
 * @author pengliang on 2018-08-06 10:22
 */
public class MyAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(HttpConstant.APPLICATION_JSON_UTF8);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), ResultData.createResultData(HttpServletResponse.SC_UNAUTHORIZED, "访问令牌过期", authException));
    }
}
