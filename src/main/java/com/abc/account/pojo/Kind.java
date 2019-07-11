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

    @Override
    public String toString() {
        return "Kind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Kind(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Kind() {
    }
}
