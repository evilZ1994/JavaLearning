package BaseKnowledge.AnonymousInnerClass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        // 匿名内部类

        Message msg = new MessageImp();
        fun(msg);
        // 如果以上方法只需要使用一次，则不需要单独新建一个类
        // 可以使用匿名内部类
        fun(new Message() {
            @Override
            public void print() {
                System.out.println("hello world");
            }
        });
        // Lambda表达式
        fun(() -> System.out.println("hello world"));

        // 使用匿名内部类的时候有一个前提：必须基于接口或抽象类的应用。

        // 如果匿名内部类定义在方法里，方法的参数或者是变量要被匿名内部类访问，方法的
        // 参数或者变量声明为final，（JDK1.8之后此要求被改变）
    }

    private static void fun(Message msg) {
        msg.print();
    }
}

interface Message {
    void print();
}

class MessageImp implements Message {

    @Override
    public void print() {
        System.out.println("hello world");
    }
}
