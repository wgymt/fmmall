package com.wgymt.service;

import com.wgymt.vo.ResultVO;

public interface UserService {

    // 用户注册
    ResultVO userRegister(String name, String password);

    // 用户登陆
    ResultVO checkLogin(String name, String password);
}
