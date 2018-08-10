package com.github.pengliangs.oauth.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pengliangs.oauth.constant.HttpConstant;
import com.github.pengliangs.oauth.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败
 *
 * @author pengliang on 2018-08-04 15:34
 */
@Slf4j
@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败");

        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        response.setStatus(status);
        response.setContentType(HttpConstant.APPLICATION_JSON_UTF8);
        response.getWriter().write(objectMapper.writeValueAsString(ResultData.createResultData(status, "用户名或密码不正确!", exception)));
    }

}
