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


public class DelLine {
    private static String filename1;
    private static String filename2;
    public static void main(String[] args) {
        filename1="E:\\ceshi\\hello.doc";
        filename2="E:\\ceshi\\aa1.doc";
        File file=new File(filename1);
        File file2=new File(filename2);
        if(file2.exists()){
            file2.delete();
            file2=new File(filename2);
        }else {
            file2=new File(filename2);
        }
        InputStream is=null;
        BufferedReader br = null;
        String tmp;
        FileWriter writer=null;
        int i=0;
        try {
            is=new BufferedInputStream(new FileInputStream(file));
            br = new BufferedReader(new InputStreamReader(is, "GBK"));
            writer = new FileWriter(filename2, true);
            while((tmp=br.readLine())!=null){
                if(StringUtils.isBlank(tmp));
                else{
                    writer.write(tmp+"\n");
                    i++;
                    System.out.println(i);
                }
            }
            writer.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}