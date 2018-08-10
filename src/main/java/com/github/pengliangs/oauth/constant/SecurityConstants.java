package com.github.pengliangs.oauth.constant;

/**
 * @author pengliang on 2018-07-31 17:08
 */
public interface SecurityConstants {

    /**
     * 登录页面地址
     */
    String LOGIN_PAGE = "/authentication/login";

    /**
     * 登录服务验证地址
     */
    String AUTHENTICATION_FORM = "/authentication/form";

    /**
     * 存储token前缀
     */
    String TOKEN_STORE_PREFIX = "CTBAN_TOKENT_STORE_KEY";

    /**
     * jwt签名密钥
     */
    String SIGN_KEY = "CTBAN";

    /**
     * oa_oauth_client_details表字段
     */
    String CLIENT_FIELDS = " client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove ";

    /**
     * JdbcClientDetailsService 查询语句
     */
    String CLIENT_SELECT_ALL = "SELECT " + CLIENT_FIELDS
            + " FROM oa_oauth_client_details";

    /**
     * 默认的查询语句
     */
    String CLIENT_SELECT_ALL_ORDER_BY_CLIENT_ID = CLIENT_SELECT_ALL + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    String CLIENT_SELECT_BY_CLIENT_ID = CLIENT_SELECT_ALL + " where client_id = ?";
}
