package com.github.pengliangs.oauth.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户 DTO
 *
 * @author pengliang 2018-07-21 15:21
 */
@Data
public class UserDTO implements Serializable{
    /**
     * 用户id编号
     */
    private Long id;

    /**
     * 用户名称（格式为手机号码，管理员除外）
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

}