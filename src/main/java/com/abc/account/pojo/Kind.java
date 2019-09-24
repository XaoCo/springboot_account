package com.abc.account.pojo;

import java.io.Serializable;

/**
 * package: com.abc.account.pojo
 * auther： abc
 * date: 2019/7/9 23:20
 * introduce: 类别实体类
 */
public class Kind implements Serializable {
    private int id;
    private String name;
    private String flag;

    public Kind() {
    }

    public Kind(int id, String name, String flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
