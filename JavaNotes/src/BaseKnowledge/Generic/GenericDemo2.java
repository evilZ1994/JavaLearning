package BaseKnowledge.Generic;

public class GenericDemo2 {
    public static void main(String[] args) {
        // 通配符"?"

        Message<String> m = new Message<>();
        m.setMsg("Hello world");
        fun(m);

        Message<Integer> m2 = new Message<>();
        m2.setMsg(10);
        // fun方法接收的参数为Message<BaseKnowledge.String>类型，而且不能根据不同的泛型类型进行重载
        // fun(m2); // 此时无法调用这个方法
        // 用通配符"?"解决：
        fun2(m);
        fun2(m2);

        // 通配符"?"基础上还有两个子的通配符：
        // 1. ？extends类：设置泛型上限，可以在声明上和方法参数上使用
        //      ?extends Number: 意味着可以设置Number或者是Number的子类
        // 2. ?super类：设置泛型下限，方法参数上使用
        //      ?super BaseKnowledge.String: 意味着只能够设置String或者是它的父类Object

        // 泛型上限：
        NumMsg<Integer> numMsg = new NumMsg<>();
        numMsg.setMsg(10);
        // NumMsg<BaseKnowledge.String> numMsg1 = new NumMsg<BaseKnowledge.String>(); // String不是Number的子类，不能设置
    }

    public static void fun(Message<String> temp) {
        System.out.println(temp.getMsg());
    }

    public static void fun2(Message<?> temp) {
        // 用通配符?表示，此时只能取出，不能设置
        // temp.setMsg("hello"); // 不能设置
        System.out.println(temp.getMsg());
    }
}

class Message<T> {
    private T msg;

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}

/**
 * 泛型上限
 * @param <T> 泛型，只能设置Number及其子类
 */
class NumMsg<T extends Number> {
    private T msg;

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
