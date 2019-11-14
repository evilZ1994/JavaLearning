package BaseKnowledge.Java8NewFeatures;

public class LamdaDemo {
    public static void main(String[] args) {
        // Lambda表达式，函数式编程

        // 传统匿名内部类
        fun(new IMessage() {
            @Override
            public void print() {
                System.out.println("Hello");
            }
        });
        // Lambda表达式
        fun(() -> System.out.println("Hello"));

        // Lambda语法有三种形式
        // 1. (参数) -> 单行语句
        // 2. (参数) -> {单行语句}
        // 3. (参数) -> 表达式

        // 有参示例
        fun2((s) -> System.out.println("Hello World"));
        // 多行
        fun2((s -> {
            s = s.toUpperCase();
            System.out.println(s);
        }));
        // 多个参数，表达式
        fun3((x, y) -> x + y); // 如果只是一个表达式，那么操作的返回可以不用写return
    }

    public static void fun(IMessage msg) {
        msg.print();
    }

    public static void fun2(IMessage2 msg) {
        msg.print("Hello");
    }

    public static void fun3(IMath math) {
        System.out.println(math.add(10, 20));
    }
}

interface IMessage2 {
    public void print(String s);
}

interface IMath {
    public int add(int x, int y);
}
