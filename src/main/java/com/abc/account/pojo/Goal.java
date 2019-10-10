package com.abc.account.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * package: com.abc.account.pojo
 * auther： abc
 * date: 2019/9/19 22:49
 * introduce: TODO
 */
public class Goal implements Serializable {
    private int id;
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
//    定目标人
    private String userName;

    public Goal() {
    }

    public Goal(int id, String goalName, String goalDesc, String goalTotal, String goalPercent, String endDate, String process, String userName) {
        this.id = id;
        this.goalName = goalName;
        this.goalDesc = goalDesc;
        this.goalTotal = goalTotal;
        this.goalPercent = goalPercent;
        this.endDate = endDate;
        this.process = process;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", goalName='" + goalName + '\'' +
                ", goalDesc='" + goalDesc + '\'' +
                ", goalTotal='" + goalTotal + '\'' +
                ", goalPercent='" + goalPercent + '\'' +
                ", endDate='" + endDate + '\'' +
                ", process='" + process + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
