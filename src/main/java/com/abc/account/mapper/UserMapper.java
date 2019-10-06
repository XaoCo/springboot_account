package com.abc.account.mapper;

import com.abc.account.pojo.FamilyPosition;
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

    User selectByName(User user);
 //    用户查询

    User selectByEmail(User user);

    //     用户注册
    int addUser(User user);

    //    用户修改密码
    int updPassword(User user);

    //    删除用户
    int delUser(@Param("name") String name);

    //    获取用户列表
    List<User> getAllUser();

    //    获取家庭地位
    List<FamilyPosition> findAllPosition();

    //    修改信息
    int modifyInformation(User user);

}
