package BaseKnowledge.Override;

public class OverrideDemo1 {
    public static void main(String[] args) {
        // 1.方法的覆写
        // 当子类定义了与父类方法名相同、参数的类型及个数、返回值相同的方法时
        B b = new B();
        b.fun();

        // 被子类所覆写的方法不能够拥有比父类更严格的访问控制权限
        // 如果父类的方法是public，子类覆写时也只能是public，如果父类的方法是default，子类覆写是只能使用default或public
        // 如果父类的方法是private，此时这个方法对子类是不可见的，即使子类定义与此方法相同的方法也不能算是覆写，相当于子类重新定义了一个方法。

        // 子类覆写的方法中可以使用super调用父类中的方法

        // 重载(Overloading)与覆写(BaseKnowledge.Override)
        // 发生范围：发生在一个类里         --- 发生在继承中
        // 定义：方法名称、参数类型及个数相同 --- 方法名称、参数类型及个数、方法返回值相同
        // 权限： 没有权限限制              --- 被覆写的方法不能拥有比父类更严格的控制权限
        // 在发生重载关系的时候，返回值可以不同，但是考虑到程序设计的统一性，尽量保证方法的返回值相同

        // 2. 属性的覆盖
        b.print(); // 打印"World"

        // super和this的区别
        // 功能：调用本类构造、本类方法、本类属性 --- 子类调用父类构造、方法和属性
        // 形式：先查找本类中是否存在指定的调用结构，有则直接调用，无则调用父类定义 --- 不查找子类，直接调用父类操作
        // 当前对象：表示本类的当前对象 --- （无）
        // 在开发中，对于本类或是父类中的操作，尽量加上"this."或者"super."，方便区分
    }
}

class A {
    String info = "Hello";

    public void fun() {
        System.out.println("A的fun");
    }
}

class B extends A {
    // 属性的覆盖
    // 在开发中，类中的属性尽量封装（private），封装后的父类属性在子类中不可见，
    // 所以属性的覆盖几乎没有意义
    String info = "World";

    @Override
    public void fun() {
        // super.fun();
        System.out.println("B的fun");
    }

    public void print() {
        System.out.println(this.info);
    }
}
