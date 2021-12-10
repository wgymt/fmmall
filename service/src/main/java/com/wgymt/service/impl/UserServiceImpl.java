package com.wgymt.service.impl;

import com.wgymt.entity.User;
import com.wgymt.mapper.UserMapper;
import com.wgymt.service.UserService;
import com.wgymt.utils.MD5Utils;
import com.wgymt.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    @Transactional
    public ResultVO userRegister(String name, String password) {
        synchronized (this) {
            // 检测数据库是否存在该用户
            User user = mapper.queryUserByName(name);

            // 若没有该用户则进行注册操作
            if (user != null) {
                return new ResultVO(10002, "用户已存在", null);
            } else {
                // 给密码加点料
                String md5Pwd = MD5Utils.md5(password);
                user = new User();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());

                // 写入数据库
                Integer row = mapper.insertUser(user);
                if (row > 0) {
                    // 影响行数大于0, 说明插入成功
                    return new ResultVO(10000, "用户注册成功", user);
                } else {
                    return new ResultVO(10001, "用户注册失败", null);
                }
            }
        }
    }

    @Override
    public ResultVO checkLogin(String name, String password) {
        // 查询该用户是否存在
        User user = mapper.queryUserByName(name);

        // 若不存在返回错误提示
        if (user == null) {
            return new ResultVO(20002, "用户名或者密码不存在", null);
        } else {
            // 给输入的密码加料以匹配数据库中的密码
            String md5Pwd = MD5Utils.md5(password);

            // 判断传入的密码是否和数据库中一致
            if (user.getPassword().equals(md5Pwd)) {
                return new ResultVO(20000, "登陆成功", user);
            } else {
                return new ResultVO(20002, "用户名或者密码不存在", null);
            }
        }
    }
}
