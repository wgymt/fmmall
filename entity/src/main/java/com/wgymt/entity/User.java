package com.wgymt.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User对象", description = "用户/买家信息")
public class User {

    /*主键 用户 id*/
    private Integer userId;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*昵称*/
    private String nickname;
    /*真实姓名*/
    private String realname;
    /*头像*/
    private String userImg;
    /*手机号*/
    private String userMobile;
    /*邮箱*/
    private String userEmail;
    /*性别 男M 女F*/
    private String userSex;
    /*生日*/
    private Date userBirth;
    /*注册时间, 创建时间*/
    private Date userRegtime;
    /*更新时间*/
    private Date userModtime;
}
