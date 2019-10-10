package com.abc.account.controller;

import com.abc.account.pojo.Goal;
import com.abc.account.pojo.User;
import com.abc.account.service.GoalService;
import com.abc.account.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * package: com.abc.account.controller
 * auther： abc
 * date: 2019/9/20 15:45
 * introduce: 目标
 */
@Controller
@RequestMapping("/goal")
public class GoalController {
    @Autowired
    private GoalService goalService;

    //    实例化日志
    Logger logger = LoggerFactory.getLogger(this.getClass());


    //新增目标
    @RequestMapping("/addGoal")
    @ResponseBody
    public int userRegister(
            @RequestParam("goalName") String goalName,
            @RequestParam("goalDesc") String goalDesc,
            @RequestParam("goalTotal") String goalTotal,
            @RequestParam("endDate") String endDate,
            HttpServletRequest request) {

        Goal goal = new Goal();
        int flag = 0;
//获取用户
        User user_session = (User) request.getSession().getAttribute("user_session");
        goal.setGoalName(goalName);
        goal.setGoalDesc(goalDesc);
        goal.setGoalTotal(goalTotal);
        goal.setEndDate(endDate);
        goal.setGoalPercent("");
        goal.setProcess("");
        goal.setUserName(user_session.getMails());
        int i = goalService.addGoal(goal);

        if (i == 1) {
            logger.info(this.getClass() + "新增目标成功！");
            flag = 1;
        } else {
            flag = -1;
            logger.info(this.getClass() + "新增目标失败！");
        }


        return flag;
    }

    //历史目标
    @RequestMapping("/findAllGoals")
    @ResponseBody
    public List<Goal> findAllGoals(
            HttpServletRequest request
    ) {

        User user_session = (User) request.getSession().getAttribute("user_session");
        List<Goal> allGoals = new ArrayList<>();
        List<Goal> allGoal = goalService.getAllGoal(user_session.getMails());

        for (Goal goal : allGoal) {

        }

        return allGoal;
    }


    //修改目标
    @RequestMapping("/modifygoal")
    @ResponseBody
    public int modifygoal(
            @Param("modifygoalName") String modifygoalName,
            @Param("modifygoalTotal") String modifygoalTotal,
            @Param("modifygoalendDate") String modifygoalendDate,
            @Param("modifygoalId") String modifygoalId,
            HttpServletRequest request
    ) {

        Goal goal = new Goal();
        goal.setGoalName(modifygoalName);
        goal.setGoalTotal(modifygoalTotal);
        goal.setEndDate(modifygoalendDate);
        goal.setId(Integer.valueOf(modifygoalId));
        int flag = 0;
        int i = goalService.updateGoal(goal);

        if (i < 1) {
            flag = -1;
        }

        return flag;
    }


}
