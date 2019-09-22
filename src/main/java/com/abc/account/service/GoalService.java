package com.abc.account.service;

import com.abc.account.pojo.Goal;

import java.util.List;

/**
 * package: com.abc.account.service
 * auther： abc
 * date: 2019/9/20 16:09
 * introduce: TODO
 */
public interface GoalService {
    //    新增目标
    int addGoal(Goal goal);
    //    删除目标
    int delGoal(Goal goal);
    //    修改目标
    int updateGoal(Goal goal);
    //    查询目标
    List<Goal> getAllGoal();
}
