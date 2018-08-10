package com.github.pengliangs.oauth.service;

import com.github.pengliangs.oauth.dto.UserDTO;

/**
 * @author pengliang on 2018-08-01 16:58
 */
public interface UserService {

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserDTO findUserInfo(String username);
}
