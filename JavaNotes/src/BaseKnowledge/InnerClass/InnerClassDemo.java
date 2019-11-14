package BaseKnowledge.InnerClass;

public class InnerClassDemo {
    public static void main(String[] args) {
        // 从开发角度，内部类能少用就少用

        // 实例化外部类
        Outer outer = new Outer();
        // 调用外部类方法
        outer.fun(); // 打印 "Hello World"

        // 内部类最大的优点：可以访问外部类的私有操作

        // 外部类对象实例化后可以实例化内部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.print();

        // 内部类可以在任意位置定义，包括：类中，代码块中，方法中
        outer.fun2("方法参数");
    }
}

class Outer {
    private String msg = "Hello World";

    // private可以修饰内部类，使之不能在外部实例化
    // static可以修饰内部类，使之相当于一个外部类，且只能访问外部类的static属性
    // static内部类在外部实例化时：Outer.Inner inner = new Outer.Inner();
    class Inner {
        private String info = "ABC";

        public void print() {
            // 可以访问外部类私有变量
            System.out.println(msg);
            // 外部类.this = 外部类的当前对象
            System.out.println(Outer.this.msg);
        }
    }

    public void fun() {
        // 实例化内部类对象并调用内部类方法
        Inner in = new Inner();
        in.print();
        // 外部类可以利用内部类对象访问内部类的私有属性
        System.out.println(in.info);
    }

    public void fun2(String info) {
        // 在方法中定义内部类
        // 方法中的内部类可以访问方法的参数以及定义的变量（jdk1.8及以后的版本）
        // jdk1.7及以前的版本需要将方法参数和方法变量声明为"final"才能被访问
        String val = "方法变量";
        class Inner2 {
            public void print() {
                System.out.println(info);
                System.out.println(val);
                System.out.println(Outer.this.msg);
            }
        }
        new Inner2().print();
    }
}
