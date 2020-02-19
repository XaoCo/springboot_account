package com.abc.account.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2  {
    public static void main(String[] args) {

//        Boolean flag = false;
//        if(flag = true){
//            System.out.println("true");
//        }else{
//
//            System.out.println("false");
//        }
        List list = new ArrayList();
        Set set = new HashSet();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);

        set.add(5);
        set.add(5);
        set.add(3);
        set.add(8);

        System.out.println("list大小"+list.size());
        System.out.println("set大小"+set.size());

        for (Object i:list) {
            System.out.print(i);
        }
        for (Object i:set) {
            System.out.print(i);
        }
    }
}
