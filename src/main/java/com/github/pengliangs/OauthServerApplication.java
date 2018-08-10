package com.github.pengliangs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tk.mybatis.spring.annotation.MapperScan;
import com.github.pengliangs.oauth.properties.SecurityProperties;

/**
 * @author pengliang on 2018-07-31 14:45
 */
@SpringBootApplication
@EnableConfigurationProperties(SecurityProperties.class)
@MapperScan(basePackages = {"com.github.pengliangs.oauth.mapper"})
public class OauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class);
    }

}
