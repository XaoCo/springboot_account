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
        subByByte(ss, 10);
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
}
