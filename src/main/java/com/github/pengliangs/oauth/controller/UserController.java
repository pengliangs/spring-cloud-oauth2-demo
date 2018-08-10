package com.github.pengliangs.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengliang on 2018-07-31 16:28
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public Object user(Authentication authentication) {
        return authentication;
    }
}
