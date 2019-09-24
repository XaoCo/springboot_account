package com.abc.account.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * package: com.abc.account.pojo
 * auther： abc
 * date: 2019/9/20 9:07
 * introduce: 预留支出
 */
public class PreOut implements Serializable {
//    预留支出名称
    private String preOutName;
//    预留支出简述
    private String preOutDesc;
//    预留支出金额
    private BigDecimal charge;
//    预留支出时间
    private Date date;

    public PreOut(String preOutName, String preOutDesc, BigDecimal charge, Date date) {
        this.preOutName = preOutName;
        this.preOutDesc = preOutDesc;
        this.charge = charge;
        this.date = date;
    }

    public String getPreOutName() {
        return preOutName;
    }

    public void setPreOutName(String preOutName) {
        this.preOutName = preOutName;
    }

    public String getPreOutDesc() {
        return preOutDesc;
    }

    public void setPreOutDesc(String preOutDesc) {
        this.preOutDesc = preOutDesc;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PreOut{" +
                "preOutName='" + preOutName + '\'' +
                ", preOutDesc='" + preOutDesc + '\'' +
                ", charge=" + charge +
                ", date=" + date +
                '}';
    }
}
