package com.github.pengliangs.oauth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * security配置
 * @author pengliang on 2018-08-04 11:11
 */
@Data
@ConfigurationProperties(prefix = "com.github.pengliangs.oauth")
public class SecurityProperties {

    private IgnoreProperties ignore = new IgnoreProperties();

}
