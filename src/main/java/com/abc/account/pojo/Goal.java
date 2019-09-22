package com.abc.account.pojo;

import java.util.Date;

/**
 * package: com.abc.account.pojo
 * auther： abc
 * date: 2019/9/19 22:49
 * introduce: TODO
 */
public class Goal {
    private int goalId;
//    目标名称
    private String goalName;
//    目标简述
    private String goalDesc;
//    目标总任务
    private String goalTotal;
//    目标现完成
    private String goalPercent;
//    最终完成期限
    private String  endDate;
//    现在进度
    private String process;

    public Goal(String goalName, String goalDesc, String goalTotal, String goalPercent, String endDate, String process) {
        this.goalName = goalName;
        this.goalDesc = goalDesc;
        this.goalTotal = goalTotal;
        this.goalPercent = goalPercent;
        this.endDate = endDate;
        this.process = process;
    }

    public Goal() {
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getGoalDesc() {
        return goalDesc;
    }

    public void setGoalDesc(String goalDesc) {
        this.goalDesc = goalDesc;
    }

    public String getGoalTotal() {
        return goalTotal;
    }

    public void setGoalTotal(String goalTotal) {
        this.goalTotal = goalTotal;
    }

    public String getGoalPercent() {
        return goalPercent;
    }

    public void setGoalPercent(String goalPercent) {
        this.goalPercent = goalPercent;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalName='" + goalName + '\'' +
                ", goalDesc='" + goalDesc + '\'' +
                ", goalTotal='" + goalTotal + '\'' +
                ", goalPercent='" + goalPercent + '\'' +
                ", endDate=" + endDate +
                ", process='" + process + '\'' +
                '}';
    }
}
