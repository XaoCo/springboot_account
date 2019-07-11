package com.abc.account.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * package: com.abc.account.pojo
 * auther： abc
 * date: 2019/7/9 23:24
 * introduce: TODO
 */
public class InOutAll implements Serializable {
    private int id;
    private String u_name;
    private String k_name;
    private int flag;
    private String desc;
    private BigDecimal charge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getK_name() {
        return k_name;
    }

    public void setK_name(String k_name) {
        this.k_name = k_name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "InOutAll{" +
                "id=" + id +
                ", u_name='" + u_name + '\'' +
                ", k_name='" + k_name + '\'' +
                ", flag=" + flag +
                ", desc='" + desc + '\'' +
                ", charge=" + charge +
                '}';
    }

    public InOutAll(int id, String u_name, String k_name, int flag, String desc, BigDecimal charge) {
        this.id = id;
        this.u_name = u_name;
        this.k_name = k_name;
        this.flag = flag;
        this.desc = desc;
        this.charge = charge;
    }

    public InOutAll() {
    }
}
