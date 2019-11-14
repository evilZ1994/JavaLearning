package BaseKnowledge.Reference;

class Message {
    private int num = 10;
    public Message(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class Message3 {
    private String msg;

    public Message3(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

public class ReferenceDemo1 {
    public static void main(String[] args) {
        // 引用传递
        // 引用传递的核心意义：同一块堆内存可以被多个栈内存所指向，多个栈内存可以操作同一个堆内存

        // 案例1
        Message msg = new Message(30);
        fun(msg); // 传递 msg对象的引用
        System.out.println(msg.getNum()); // 输出40

        // 案例2
        String str = "Hello";
        fun2(str);
        System.out.println(str); // 输出"Hello"

        // 案例3
        Message3 msg3 = new Message3("Hello");
        fun3(msg3);
        System.out.println(msg3.getMsg()); // 输出"World"
    }

    private static void fun(Message temp) {
        // 修改temp所指向的对象的属性
        temp.setNum(40);
    }

    private static void fun2(String temp) {
        // 此处只是修改了temp引用的指向
        temp = "World";
    }

    private static void fun3(Message3 temp) {
        // 修改了temp所指向的对象中的属性msg的指向
        temp.setMsg("World");
    }
}
