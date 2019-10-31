package com.abc.account.mapper;

import com.abc.account.pojo.Goal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * package: com.abc.account.mapper
 * auther： abc
 * date: 2019/9/20 15:47
 * introduce: TODO
 */
public interface GoalMapper {
    //    新增目标
    int addGoal(Goal goal);

    //    删除目标
    int delGoal(Goal goal);

    //    修改目标
    int updateGoal(Goal goal);

    //    查询目标
    List<Goal> getAllGoal(@Param("name") String name);

}
