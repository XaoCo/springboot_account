package com.abc.account.mapper;

import com.abc.account.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * package: com.abc.account.mapper
 * auther： abc
 * date: 2019/7/10 9:47
 * introduce: TODO
 */
public interface UserMapper {
    //    用户登录

    User login(User user);

    //    用户查询

    User login1(User user);

    //     用户注册
    int addUser(User user);

    //    用户修改密码
    int updPassword(User user);

    //    删除用户
    int delUser(@Param("id") int id);

    //    获取用户列表
    List<User> getAllUser();

}
