package com.wgymt.controller;

import com.wgymt.service.UserService;
import com.wgymt.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(value = "提供用户登陆和注册的接口", tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("用户登陆接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "用户登陆账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "用户登陆密码", required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        return userService.checkLogin(username, password);
    }

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "用户注册账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "用户注册密码", required = true)
    })
    @PostMapping("/register")
    public ResultVO register(String username, String password) {
        return userService.userRegister(username, password);
    }
}
