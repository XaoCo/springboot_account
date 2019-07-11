package com.abc.account.mapper;

import com.abc.account.pojo.InOutAll;
import com.abc.account.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * package: com.abc.account.mapper
 * auther： abc
 * date: 2019/7/10 9:47
 * introduce: TODO
 */
public interface UserMapper {
    //    用户登录

    User login(@Param("name") String username, @Param("password") String password);

    //     用户注册
    int addUser(User user);

    //    获取用户列表
    List<User> getAllUser();

    //    获取当前登录用户的收支状况
    List<InOutAll> getAllCount();
}
