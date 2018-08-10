package com.github.pengliangs.oauth.config;

import com.github.pengliangs.oauth.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author pengliang on 2018-08-04 18:17
 */
@Configuration
public class TokenStoreConfig {


    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix(SecurityConstants.TOKEN_STORE_PREFIX);
        return tokenStore;
    }

}
