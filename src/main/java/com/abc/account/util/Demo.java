package com.abc.account.util;

/**
 * package: com.abc.account.util
 * auther： abc
 * date: 2019/9/19 14:17
 * introduce: 关于买西瓜的问题
 */
public class Demo {
    public static void main(String[] args) {
//        买西瓜的个数
        int i = 0;
//        西红柿的个数
        int j = 0;
//        回家买西瓜,买一个
        System.out.println("回家买西瓜,买一个,");
        i = 1;
        j = 2;
        System.out.println("看见了西红柿,老婆说得买俩,");
        if (j > 0) {//如果看到了西红柿,就买俩
            i = 2;
            System.out.println("买" + i + "个西瓜回家喽!");
        }
        System.out.println("老婆说,你是个二傻子!");
        System.out.println("我哪里出bug了???");
    }
}
