package com.abc.account.pojo;

import java.util.Date;

/**
 * package: com.abc.account.pojo
 * auther： abc
 * date: 2019/9/19 22:49
 * introduce: TODO
 */
public class Goal {
    private String goalName;
    private String goalDesc;
    private String goalTotal;
    private String goalPercent;
    private Date endDate;
    private String process;

    public Goal(String goalName, String goalDesc, String goalTotal, String goalPercent, Date endDate, String process) {
        this.goalName = goalName;
        this.goalDesc = goalDesc;
        this.goalTotal = goalTotal;
        this.goalPercent = goalPercent;
        this.endDate = endDate;
        this.process = process;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
