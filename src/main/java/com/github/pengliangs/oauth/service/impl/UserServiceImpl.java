package com.github.pengliangs.oauth.service.impl;

import com.github.pengliangs.oauth.domain.UserDO;
import com.github.pengliangs.oauth.dto.UserDTO;
import com.github.pengliangs.oauth.mapper.UserMapper;
import com.github.pengliangs.oauth.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author pengliang on 2018-08-01 16:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO findUserInfo(String username) {
        Example example = new Example(UserDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        UserDTO userDTO = new UserDTO();
        List<UserDO> userDOList = userMapper.selectByExample(example);
        if (!ListUtils.isEmpty(userDOList)) {
            BeanUtils.copyProperties(userDOList.get(0), userDTO);
        }
        return userDTO;
    }
}
