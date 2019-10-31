package com.abc.account.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * package: com.abc.account.util
 * auther： abc
 * date: 2019/8/5 22:20
 * introduce: TODO
 */
public class DateUtils {
    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("现在的时间为：" + simpleDateFormat.format(date));
//        System.out.println("10天后的时间为：" + simpleDateFormat.format(new Date(date.getTime() + 10 * 24 * 60 * 60 * 1000)));
        System.out.println("===================================================");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println("年：" + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("月：" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("周：" + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("时间：" + calendar.get(Calendar.DATE));


    }

    public String getAll() {
        return null;
    }


}
