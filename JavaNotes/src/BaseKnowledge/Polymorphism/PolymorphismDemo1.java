package BaseKnowledge.Polymorphism;

public class PolymorphismDemo1 {
    public static void main(String[] args) {
        // 多态

        // 方法的多态性：
        // 方法的重载：同一个方法名称，会根据传入的参数类型及个数不同，实现不同的功能
        // 方法的覆写：同一个方法，会根据子类的不同，实现不同的功能

        // 对象的多态性：
        // 放生在继承关系之中，子类和父类之间的转换关系
        // 向上转型（自动完成）：Parent p = c;
        // 向下转型（强制完成）：Child c = (Child)p;
        A a1 = new B(); // 向上转型
        A a2 = new C(); // 向上转型
        B b2 = (B)a1; // 向下转型
        a1.print(); // B Print
        a2.print(); // C Print
        b2.print(); // B Print

        // 向下转型是为了父类调用子类自己特殊的方法
        A a3 = new B();
        B b3 = (B)a3;
        b3.fun();

        // 大多数情况下都只会使用向上转型，因为可以得到参数类型的同一，方便于我们的程序设计
        // 一些情况会使用向下转型，目的是调用子类的特殊方法

        // 向下转型存在风险。两个没有关系的类对象强制发生向下转型会引发ClassCastException
        // A a4 = new A();
        // B b4 = (B)a4; // ClassCastException，因为从父类来看，A并不知道B是否是自己的子类
        // 为了保证转型的顺利进行，在Java中提供一个关键字：instanceof
        A a5 = new B();
        if (a5 instanceof B) {
            B b5 = (B)a5; // 向下转型
        }
        // 对于向下转型，发生之前，一定要首先发生对象的向上转型，建立关系后才能进行
    }
}

class A {
    public void print() {
        System.out.println("A Print");
    }
}

class B extends A {
    @Override
    public void print() {
        System.out.println("B Print");
    }

    public void fun() {
        System.out.println("B fun");
    }
}

class C extends A {
    @Override
    public void print() {
        System.out.println("C Print");
    }
}
