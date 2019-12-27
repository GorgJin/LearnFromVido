package com.learnnote;

public class Student extends Person {
private int age=8;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
   // public void show(){

   //     System.out.println("子类中的show方法");
   // }

    public void run(){
        System.out.println("子类中的run方法");

    }

     public void eat(Student s){
        System.out.println("学生吃饭");

     }

     public static void play(){

        System.out.println("子类中的静态方法play");
     }
}
