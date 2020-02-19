package com.abc.account.util;

/**
 * 比较两个版本号
 */
public class Demo1 {
    public static void main(String[] args) {

//      定义两个版本号
        String version1 = "1.2.1.8";
        String version2 = "1.2.1.6.9";

//        定义几个字段
        int length = 0;
        int length1 = 0;
        int length2 = 0;
        int a = 0;
        int b = 0;

//        分割字符串
        String[] strings1 = version1.split("\\.");
        length1 = strings1.length;


        String[] strings2 = version2.split("\\.");

        length2 = strings2.length;

//        赋值length
        if (length1 > length2) {
            length = length2;
        } else {
            length = length1;
        }

        for (int i = 0; i < length; i++) {
            a = Integer.parseInt(strings1[i]);
            b = Integer.parseInt(strings2[i]);

            if (a > b) {

                System.out.println("version1高于version2   ===== 1 =====");
                break;
            } else if (a < b) {
                System.out.println("version1低于version2   ===== -1 =====");
                break;
            } else {
                if (i == length - 1 && length1 == length2) {
                    System.out.println("version1等于version2   ===== 0 =====");
                    break;
                } else if (i == length - 1 && length1 > length2) {
                    System.out.println("version1高于version2   ===== 1 =====");
                    break;
                } else if (i == length - 1 && length1 < length2) {
                    System.out.println("version1低于version2   ===== -1 =====");
                    break;
                }

            }
        }

    }
}
