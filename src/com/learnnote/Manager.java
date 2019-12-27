package com.learnnote;

public class Manager extends Worker{

    //项目经理类

   private double bounds;
    Manager(String name,String id,double salary,double bounds){
super(name,id,salary);
this.bounds=bounds;

    }

    @Override
    void work() {
System.out.println("manager work");
    }
}
