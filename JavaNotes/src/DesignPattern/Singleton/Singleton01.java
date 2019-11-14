package DesignPattern.Singleton;

/**
 * 单例模式1：静态内部类方式实现
 * 这种写法使用 JVM 本身机制保证了线程安全问题，由于 SingletonHolder 是私有的，
 * 除了 getInstance() 方法外没有办法访问它，因此它是懒汉式的；
 * 同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
 */
public class Singleton01 {
    private static class SingletonHolder {
        private static final Singleton01 INSTANCE = new Singleton01();
    }

    // 指定一个私有的无参构造函数，这样这个类就无法在外部被实例化
    private Singleton01() {}

    public static Singleton01 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
