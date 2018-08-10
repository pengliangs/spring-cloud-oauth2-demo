package com.github.pengliangs.oauth.config;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * jwt增强
 * @author pengliang on 2018-07-31 17:17
 */
public class JwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
       /* Map<String,Object> info = new HashMap<>();
        info.put("company","pengliang.company");
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);*/
        return accessToken;
    }
}
