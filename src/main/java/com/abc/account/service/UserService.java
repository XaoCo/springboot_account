package com.abc.account.service;

import com.abc.account.pojo.User;

import java.util.List;

/**
 * package: com.abc.account.service
 * auther： abc
 * date: 2019/7/10 9:37
 * introduce: 用户service
 */
public interface UserService {
    //    用户登录
    User login(User user);

    //    用户查询
    User login1(User user);

    //    用户注册
    int addUser(User user);

    //    用户修改密码
    int updPassword(User user);

    //    用户删除
    int delUser(String name);

    //    获取用户列表
    List<User> getAllUser();


}
