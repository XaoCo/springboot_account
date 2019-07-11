package com.abc.account.service;

import com.abc.account.pojo.InOutAll;
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
    User login(String name, String password);

    //    用户注册
    int addUser(User user);

    //    获取用户列表
    List<User> getAllUser();

    //    获取当前登录用户的收支状况
    List<InOutAll> getAllCount();
}
