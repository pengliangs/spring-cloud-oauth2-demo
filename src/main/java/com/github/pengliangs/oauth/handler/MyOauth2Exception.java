package com.github.pengliangs.oauth.handler;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 重写OAuth2Exception
 * @author pengliang on 2018-08-06 10:05
 */
@JsonSerialize(using = MyOauth2ExceptionSerializer.class)
public class MyOauth2Exception extends OAuth2Exception {

    public MyOauth2Exception(String msg) {
        super(msg);
    }
}
