package com.abc.account.service;

import com.abc.account.pojo.FamilyPosition;
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

    //    用户通过name查询
    User selectByName(User user);
//    用户通过email查询
    User selectByEmail(User user);
//    用户通过email查询
    User selectByNameOrEmail(User user);

    //    用户注册
    int addUser(User user);

    //    用户修改密码
    int updPassword(User user);

    //    用户删除
    int delUser(String name);

    //    获取用户列表
    List<User> getAllUser();

//    获取家庭地位
    List<FamilyPosition> findAllPosition();

//    修改信息
    int modifyInformation(User user);

//    找回用户名
    User findUserName(User user);


}
