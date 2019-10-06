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
    List<InAndOut> selRecord(InAndOut inAndOut);

    //    查询所有的收支记录
    List<InAndOut> selAllRecord();

    //    新增一条消费记录
    int addRecord(InAndOut inAndOut);

    //    修改一条记录
    int updRecord(InAndOut inAndOut);

    //    删除一条记录
    int delRecord(@Param("id") int id);

    //    总收入
    String findAllIn(@Param("userName") String username);

    //    总开支
    String findAllOut(@Param("userName") String username);

    //    开支明细
    List<InAndOut> getAllOut(@Param("userName") String username);

    //    收入明细
    List<InAndOut> getAllIn(@Param("userName") String username);
}
