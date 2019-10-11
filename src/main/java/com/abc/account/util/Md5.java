package com.abc.account.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * package: com.abc.account.util
 * auther： abc
 * date: 2019/10/11 20:04
 * introduce: TODO
 */
public class Md5 {
//    public static void main(String[] args) {
//        String s = "12345";
//       md5(s);
//    }

    public String md5(String s){
        String s1 =null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(s.getBytes());
            s1 = new BigInteger(1, md5.digest()).toString(16);
            System.out.println("s1="+s1);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s1;
    }
}
