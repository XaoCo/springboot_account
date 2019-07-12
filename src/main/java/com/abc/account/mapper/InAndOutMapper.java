package com.abc.account.mapper;

import com.abc.account.pojo.InAndOut;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * package: com.abc.account.mapper
 * auther： abc
 * date: 2019/7/12 13:45
 * introduce: TODO
 */
public interface InAndOutMapper {
    //    查询当前用户的收支记录
    List<InAndOut> selRecord(@Param("userName") String userName);

    //    查询所有的收支记录
    List<InAndOut> selAllRecord();

    //    新增一条消费记录
    int addRecord(InAndOut inAndOut);

    //    修改一条记录
    int updRecord(InAndOut inAndOut);

    //    删除一条记录
    int delRecord(@Param("id") int id);

}
