package com.learnnote;

public abstract  class Worker {
private String name;
private String id;
private double salary;
Worker(String name,String id,double salary){
this.name=name;
this.id=id;
this.salary=salary;

     }

     abstract  void work();
}
