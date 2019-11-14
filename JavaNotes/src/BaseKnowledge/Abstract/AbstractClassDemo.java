package BaseKnowledge.Abstract;

public class AbstractClassDemo {
    public static void main(String[] args) {
        // 抽象类
        // 抽象类就是在普通类的结构里增加抽象方法的组成部分
        // 抽象方法用abstract声明，没有方法体

        // 抽象类无法被实例化

        // 抽象类的使用：
        // 1.抽象类必须有子类
        // 2.抽象类的子类（子类不是抽象类）必须要覆写抽象类之中的全部抽象方法
        // 3.抽象类的对象实例化需要依靠子类完成，采用向上转型的方式处理
        A a = new B();
        a.print();

        // 抽象类不能使用final定义，因为抽象类必须有子类，final声明的类不能被继承
        // 外部抽象类不允许使用static声明，内部的抽象类允许使用static声明，内部用static声明的抽象类相当于一个外部抽象类
        // 任何情况下，要执行类中的static方法的时候，都不用实例化，抽象类也一样

        // 系统常见的设计：对用户隐藏不需要知道的子类
        A a1 = A.getInstance(); // 返回内部抽象类子类B的实现
        a1.print();
    }
}

abstract class A {
    public void fun() {
        // 普通方法
    }

    abstract public void print(); // 抽象方法

    // 内部静态抽象类子类
    private static class B extends A {
        @Override
        public void print() {
            System.out.println("Hello World");
        }
    }

    public static A getInstance() {
        return new B();
    }
}

class B extends A {

    @Override
    public void print() {
        // 覆写A的抽象方法
        System.out.println("B Print");
    }
}
