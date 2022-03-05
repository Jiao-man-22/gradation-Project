package com.jiao.chatonlineserver.domain;

import javax.management.relation.Role;
import java.util.List;

public class UserInfo {
    private Integer id;//用户id，自增长
    private String username;//用户名
    private String password;//用户密码
    private String phoneNum;//用户电话号码
    private String email;//用户邮箱
    private String url;//用户头像地址
    private Integer status;//用户状态
    private String statusStr;//转化用户状态
    private Integer gender;//用户性别
    private String intro;//用户简介

    private List<Role> roles;//用户所有权限
}
