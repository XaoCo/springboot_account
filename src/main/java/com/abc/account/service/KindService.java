package com.abc.account.service;

import com.abc.account.pojo.Kind;

import java.util.List;

/**
 * package: com.abc.account.service
 * auther： abc
 * date: 2019/7/12 10:17
 * introduce: TODO
 */
public interface KindService {

    //    查询种类
    List<Kind> findAllKind(String str);
//
//    //    查询所有收入种类
//    List<Kind> findAllinKind(String str);
//
//    //    查询所有收入种类
//    List<Kind> findAllPreKind(String str);

    // 根据名称查询种类信息
    Kind findByName(String name);

    //    新增种类
    int addKind(String name);

    //    修改种类名称
    int updKind(int id, String name);

    //    删除某一种类
    int delKind(int id);
}
