package com.wgymt.mapper;

import com.wgymt.entity.User;

public interface UserMapper {

    // 新增用户
    Integer insertUser(User user);

    // 根据用户名查询用户
    User queryUserByName(String username);
}
