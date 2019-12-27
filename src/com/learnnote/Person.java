package com.learnnote;
//用于多态的理解
public class Person {

    private String name="jinch";
    private int age=4;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
   }

    public void setAge(int age) {
        this.age = age;
   }

public void show(){

        System.out.println(" 父类中的 show方法");
}

public void eat(Person p){
System.out.println("人类吃饭");

}

public static void play(){

       System.out.println("父类中的静态方法play");
}


}
