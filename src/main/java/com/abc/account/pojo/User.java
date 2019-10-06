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
    //    private int age;
    private String mails;
    private String password;
    private String position;

    public User(int id, String name, String mails, String password, String position) {
        this.id = id;
        this.name = name;
        this.mails = mails;
        this.password = password;
        this.position = position;
    }

    public int getId() {
        return id;
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

    public String getMails() {
        return mails;
    }

    public void setMails(String mails) {
        this.mails = mails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User() {
    }
}
