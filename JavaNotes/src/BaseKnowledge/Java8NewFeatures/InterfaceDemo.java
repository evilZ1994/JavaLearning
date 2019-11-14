package BaseKnowledge.Java8NewFeatures;

public class InterfaceDemo {
    public static void main(String[] args) {
        // 接口定义增强

        // 假设有某一个接口，产生了许多子类。要在接口中增加一个新方法，而且对于每个子类，这个
        // 方法的功能实现是完全一样的。按照最初的做法，应该在每个子类中覆写该方法。
        // JDK8为了解决这样的问题，允许在接口里面定义普通方法了。但是如果要定义普通方法，就必须用default来定义
        IMessage msg = new MessageImpl();
        msg.fun(); // 此方法是接口中直接定义的

        // 除了default，还可以使用static定义方法，一旦用static定义方法意味着这个方法这能用类名称调用
        IMessage.get(); // 接口直接调用静态方法
    }
}

interface IMessage {
    public void print(); // 接口里原本定义的方法

    default void fun() { // 接口里定义的普通方法
        System.out.println("Hello");
    }

    static void get() {
        System.out.println("接口直接调用");
    }
}

class MessageImpl implements IMessage {

    @Override
    public void print() {

    }
}
