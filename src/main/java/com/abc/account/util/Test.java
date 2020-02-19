package com.abc.account.util;

public class Test {
   public static Test t1 = new Test();
    {
        System.out.println("111");
    }

    static {
        System.out.println("222");
    }

//    {
//        System.out.println("444");
//
//    }
    public static void main(String[] args) {

        System.out.println("333");
        String ss = "ttwert";

//        ss = 100;
        int length = ss.length();
        System.out.println(length);
    }
}