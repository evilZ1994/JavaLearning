package BaseKnowledge.Singleton;

public class Demo {
    public static void main(String[] args) {
        // 单例模式

        // 单例模式有两种：
        // 1. 饿汉式
        Singleton s = Singleton.getInstance();
        // 2. 懒汉式
        Singleton2 s2 = Singleton2.getInstance();
    }
}

class Singleton {
    // 饿汉式
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        // 私有化构造方法
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public void print() {
        System.out.println("Hello world");
    }
}

class Singleton2 {
    // 懒汉式
    private static Singleton2 instance;

    private Singleton2() {
        // 私有化构造方法
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    public void print() {
        System.out.println("Hello world");
    }
}
