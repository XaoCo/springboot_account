package com.abc.account.util;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DelLine {
    private static String filenamePath1;
    private static String filenamePath2;

    public static void main(String[] args) throws IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH.mm.ss");
        String s = simpleDateFormat.format(date);
        System.out.println("现在的时间为：" + s);
        filenamePath1 = "E:\\ceshi\\hello.doc";
        filenamePath2 = "E:\\ceshi\\" + s + "hello.doc";
//        filenamePath2 = "E:\\abc\\hello.doc";
        delLine(filenamePath1, filenamePath2);

    }

    public static void delLine(String filenamePath1, String filenamePath2) {
        File file = new File(filenamePath1);
        InputStream is = null;
        BufferedReader br = null;
        String tmp;
        FileWriter writer = null;
        int i = 0;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            br = new BufferedReader(new InputStreamReader(is, "GBK"));
            writer = new FileWriter(filenamePath2, true);
            while ((tmp = br.readLine()) != null) {
                if (StringUtils.isBlank(tmp)) ;
                else {
                    writer.write(tmp + "\n");
                    i++;
//                    System.out.println(i);
                }
            }
            writer.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}