package com.github.pengliangs.oauth.properties;

import lombok.Data;

/**
 * 忽略策略配置
 *
 * @author pengliang on 2018-08-02 11:22
 */
@Data
public class IgnoreProperties {

    /**
     * 忽略地址列表
     */
    private String[] urls = {};

}
