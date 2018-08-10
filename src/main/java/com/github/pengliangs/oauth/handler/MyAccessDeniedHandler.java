package com.github.pengliangs.oauth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pengliangs.oauth.constant.HttpConstant;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 授权失败时返回信息
 * @author pengliang on 2018-08-06 10:25
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType(HttpConstant.APPLICATION_JSON_UTF8);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        Map map = new HashMap(4);
        map.put("error", "400");
        map.put("message", accessDeniedException.getMessage());
        map.put("path", request.getServletPath());
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(map));
    }
}
