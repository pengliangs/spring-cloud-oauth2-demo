package com.github.pengliangs.oauth;

import com.github.pengliangs.oauth.dto.UserDTO;
import com.github.pengliangs.oauth.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pengliang on 2018-08-01 17:08
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OauthApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void DataSourceTests(){
       UserDTO userDTO =  userService.findUserInfo("user");
        System.out.println(userDTO);
    }
}
