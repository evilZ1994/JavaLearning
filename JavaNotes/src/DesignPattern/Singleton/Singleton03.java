package DesignPattern.Singleton;

/**
 * 单例模式3：枚举方式
 * 我们可以通过 Single03.INSTANCE 来访问实例。而且创建枚举默认就是线程安全的，并且还能防止反序列化导致重新创建新的对象。
 */
public enum Singleton03 {
    INSTANCE;

    Singleton03() {
        System.out.println("执行构造方法");
    }

    public String getName() {
        return "singleton enum";
    }

    public static void main(String[] args) {
        Singleton03 singleton = Singleton03.INSTANCE;
        System.out.println(singleton.getName());
    }
}
