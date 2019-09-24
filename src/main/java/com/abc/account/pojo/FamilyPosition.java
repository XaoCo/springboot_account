package com.abc.account.pojo;

import java.io.Serializable;

/**
 * package: com.abc.account.pojo
 * auther： abc
 * date: 2019/9/24 14:22
 * introduce: TODO
 */
public class FamilyPosition implements Serializable {
    private int id;
    private String name;

    public FamilyPosition(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public FamilyPosition() {
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

    @Override
    public String toString() {
        return "FamilyPosition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

