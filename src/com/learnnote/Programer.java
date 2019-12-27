package com.learnnote;

public class Programer extends Worker{
    // 程序猿类

    Programer(String name,String id,double salary){
super(name,id,salary);

    }

    @Override
    void work() {
System.out.println("program work");
    }
}
