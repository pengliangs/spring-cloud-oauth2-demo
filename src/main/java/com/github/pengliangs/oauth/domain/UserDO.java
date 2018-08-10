package com.github.pengliangs.oauth.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户 DO
 * table sys_user
 *
 * @author pengliang 2018-07-21 14:50
 */
@Data
@Table(name = "sys_user")
public class UserDO {
    /**
     * id
     * 用户id编号
     */
    @Column(name = "id")
    @Id
    private Long id;

    /**
     * username
     * 用户名称（格式为手机号码，管理员除外）
     */
    @Column(name = "username")
    private String username;

    /**
     * password
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * create_time
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * modify_time
     * 修改时间（默认为空）
     */
    @Column(name = "modify_time")
    private Date modifyTime;


}