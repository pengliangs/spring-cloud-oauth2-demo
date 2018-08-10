package com.github.pengliangs.oauth.service.impl;

import com.github.pengliangs.oauth.dto.UserDTO;
import com.github.pengliangs.oauth.dto.UserDetails;
import com.github.pengliangs.oauth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author pengliang on 2018-07-31 15:25
 */
@Slf4j
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户名：{}", username);
        UserDTO userDTO = userService.findUserInfo(username);
        return new UserDetails(username, userDTO.getPassword(),true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN,ROLE_CLIENT,SCOPE_READ"));
    }
}
