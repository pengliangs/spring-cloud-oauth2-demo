package com.github.pengliangs.oauth.controller;

import com.github.pengliangs.oauth.constant.SecurityConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author pengliang on 2018-07-31 19:39
 */
@Controller
public class RedirectController {

    @RequestMapping(value = SecurityConstants.LOGIN_PAGE,method = {RequestMethod.GET,RequestMethod.POST})
    public String login(){
        return "/login";
    }

}
