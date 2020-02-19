package com.abc.account.util;

public class Base {
    public Base(String s){
        System.out.println("aaa");
    }

}
 class Base1 extends Base{
    public Base1(String s){
        super(s);
        System.out.println("bbbb");
    }
}