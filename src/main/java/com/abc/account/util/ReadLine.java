package com.abc.account.util;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * package: com.abc.account.util
 * auther： abc
 * date: 2019/8/3 10:35
 * introduce: 读取文件的每一行内容
 */
public class ReadLine {
    private static String filename;

    public static void main(String[] args) {

        filename = "E:\\ceshi\\style.css";

        File file = new File(filename);
        System.out.println(file.getAbsolutePath());
        String tmp;
        int line = 1;
        if (!file.exists()) {

            System.out.println("目标文件不存在！");
        } else {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                while ((tmp = randomAccessFile.readLine()) != null) {
                    if (StringUtils.isBlank(tmp)) {
                        System.out.println("第" + line + "行为空或者全部为空格！");

                    } else {
                        System.out.println("第" + line + "行的内容为："
                                + new String(tmp.getBytes("ISO-8859-1"), "UTF-8"));
                    }
                    line++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
