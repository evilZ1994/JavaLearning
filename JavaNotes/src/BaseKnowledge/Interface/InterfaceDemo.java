package BaseKnowledge.Interface;

public class InterfaceDemo {
    public static void main(String[] args) {
        // 接口：一个类之中只是由抽象方法和全局常量所组成，使用interface声明

        // 接口使用：
        // 1. 接口使用必须有子类，但是一个子类可以用implements关键字实现多个接口
        // 2. 接口的子类（如果不是抽象类），必须覆写接口中的全部抽象方法
        // 3. 接口对象可以利用子类的向上转型进行实例化操作
        X x = new X();
        A a = x;
        B b = x;
        a.print();
        b.get();

        // 如果一个子类既要继承抽象类，又要实现接口，先写extends继承，然后implements实现

        // 在接口中定义方法时只能使用public，即使没有写上public，访问权限依然是public
        // 在接口定义方法时，尽量保证写上public
        // 接口定义方法时，abstract关键字可以省略

        // 接口不能继承抽象类。可以继承接口（extends），而且可以多继承

        // 接口里面可以定义普通内部类、抽象内部类、内部接口

    }
}

interface A {
    public static final String MSG = "Hello"; // 全局常量
    public abstract void print(); // 抽象方法
}

interface B {
    public abstract void get();
}

abstract class C {
    public abstract void fun();
}

class X extends C implements A, B {

    @Override
    public void print() {
        System.out.println("A print");
    }

    @Override
    public void get() {
        System.out.println("B get");
    }

    @Override
    public void fun() {

    }
}
