package com.learnnote;

public class Test {
    public static void main(String[] args){
        Person p=new Student();
        p.show();

//多态调用方法只能调用父类中有的方法，调用不了父类中没有的方法。
// 多态没办法调用父类中没有的方法，如果要调用，就需要在父类中添加这个方法，父类中添加了方法，具体不会调用父类中的这个方法，具体调用的还是子类的方法，所以我们可以在父类中不具体实现此方法。

    p.eat(new Student());
// 行参可以是父类的变量，传实参的时候传子类对象。   这就是利用的动态绑定。

        p.play();
       System.out.println(p.getAge());
    }

}
