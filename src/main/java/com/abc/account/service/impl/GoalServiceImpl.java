package com.abc.account.service.impl;

import com.abc.account.mapper.GoalMapper;
import com.abc.account.pojo.Goal;
import com.abc.account.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package: com.abc.account.service.impl
 * auther： abc
 * date: 2019/9/20 16:10
 * introduce: TODO
 */
@Service
public class GoalServiceImpl implements GoalService {
    @Autowired
    private GoalMapper goalMapper;
    @Override
    public int addGoal(Goal goal) {
        return goalMapper.addGoal(goal);
    }

    @Override
    public int delGoal(Goal goal) {
        return goalMapper.delGoal(goal);
    }

    @Override
    public int updateGoal(Goal goal) {
        return goalMapper.updateGoal(goal);
    }

    @Override
    public List<Goal> getAllGoal() {
        return goalMapper.getAllGoal();
    }
}
