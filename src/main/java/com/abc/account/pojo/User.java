package com.abc.account.pojo;
/**
 * package: com.abc.account.pojo
 * auther： abc
 * date: 2019/7/9 23:20
 * introduce: 用户实体类
 */

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private String job;
    private String password;
    private String identityCard;

    public int getId() {
        return id;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, int age, String job, String password, String identityCard) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.password = password;
        this.identityCard = identityCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", password='" + password + '\'' +
                ", identityCard='" + identityCard + '\'' +
                '}';
    }

    public User() {
    }
}
