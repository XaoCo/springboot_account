package com.abc.account.service.impl;

import com.abc.account.mapper.UserMapper;
import com.abc.account.pojo.InOutAll;
import com.abc.account.pojo.User;
import com.abc.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package: com.abc.account.service.impl
 * auther： abc
 * date: 2019/7/10 9:45
 * introduce: TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updPassword(User user, String passwordNew) {
        return userMapper.updPassword(user, passwordNew);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<InOutAll> getAllCount() {
        return userMapper.getAllCount();
    }


}
