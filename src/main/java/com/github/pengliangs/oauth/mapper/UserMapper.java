package com.github.pengliangs.oauth.mapper;

import com.github.pengliangs.oauth.domain.UserDO;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 用户 Dao
 *
 * @author pengliang 2018-07-21 14:50
 */
public interface UserMapper  extends Mapper<UserDO>, MySqlMapper<UserDO> {
}