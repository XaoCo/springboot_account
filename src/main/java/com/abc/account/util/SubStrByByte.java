package com.abc.account.util;

import java.io.UnsupportedEncodingException;

/**
 * package: com.abc.account.util
 * auther： abc
 * date: 2019/8/21 9:31
 * introduce: TODO
 */
public class SubStrByByte {
    public static void main(String[] args) {

        String ss = "中华人民共和国";
//        subByByte(ss, 10);
        subByByte1(ss, 10);
    }

    public static String subByByte(String str, int length) {
        try {
            int length1 = -1;
            byte[] bytes = str.getBytes("utf-8");
            length1 = bytes.length;
            if (length1 > length) {
                byte[] bytes1 = new byte[length];
                System.arraycopy(bytes, 0, bytes1, 0, length);
                System.out.println(new String(bytes1));
                return new String(bytes1);
            }
            System.out.println(str);
            return str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String subByByte1(String str, int length) {

        int length1 = str.length();
        System.out.println("length1=" + length1);
        int sum = 0;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length1; i++) {
            String s = String.valueOf(str.charAt(i));
            System.out.println("str.charAt(i)=" + str.charAt(i));
            System.out.println("s=" + s);
            try {
                int length2 = s.getBytes("utf-8").length;
                sum += length2;
                if (sum > length) {
                    break;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
