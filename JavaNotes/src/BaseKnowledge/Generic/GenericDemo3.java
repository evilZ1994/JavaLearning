package BaseKnowledge.Generic;

public class GenericDemo3 {
    public static void main(String[] args) {
        // 泛型接口
        // 形式1
        IMessage<String> msg = new MessageImpl<>();
        msg.print("Hello");
        // 形式2
        IMessage<String> msg2 = new MessageImpl2();
        msg2.print("Hello");
    }
}

interface IMessage<T> { // 设置泛型接口
    public void print(T t);
}

/**
 * 泛型接口使用形式一：子类继续使用泛型，并且父接口使用和子类同样的泛型标记
 * @param <T>
 */
class MessageImpl<T> implements IMessage<T> {

    @Override
    public void print(T t) {
        System.out.println(t);
    }
}

/**
 * 泛型接口使用形式二：子类不使用泛型，父接口明确设置泛型类型
 */
class MessageImpl2 implements IMessage<String> {

    @Override
    public void print(String s) {
        // 此时覆写的方法中，参数类型直接设置为String
        System.out.println(s);
    }
}
