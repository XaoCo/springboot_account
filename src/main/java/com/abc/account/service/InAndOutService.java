package com.abc.account.service;

import com.abc.account.pojo.InAndOut;

import java.util.List;

/**
 * package: com.abc.account.service
 * auther： abc
 * date: 2019/7/12 15:12
 * introduce: TODO
 */
public interface InAndOutService {
    //    查询当前用户的收支记录
    List<InAndOut> selRecord(InAndOut inAndOut);

    //    查询所有的收支记录
    List<InAndOut> selAllRecord();

    //    新增一条消费记录
    int addRecord(InAndOut inAndOut);

    //    修改一条记录
    int updRecord(InAndOut inAndOut);

    //    删除一条记录
    int delRecord(int id);

    //    总收入
    String findAllIn(String username);

    //    总开支
    String findAllOut(String username);

    //    开支明细
    List<InAndOut> getAllOut(String username);

    //    收入明细
    List<InAndOut> getAllIn(String username);
}
