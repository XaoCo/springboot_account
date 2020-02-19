package com.abc.account.util;
/**
 * 给定一个整数 n
 * 计算小于等于该数的非负整数中数字 1 出现的次数
 */

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        int a = 22;

        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for (int i = a; i >= 0; i--) {
            for (int j = 0; j < String.valueOf(i).length(); j++) {

                char b = String.valueOf(i).charAt(j);

                int value = Character.getNumericValue(b);
                if (value == 1) {
                    count++;
                    list.add(i);
                }

            }
        }

        System.out.println("1的总数为:" + count);
        System.out.println("所有的数字为" + list.toString());
    }
}
