package DesignPattern.Singleton;

/**
 * 单例模式2：双重检查锁
 */
public class Singleton02 {
    private static volatile Singleton02 instance = null;

    private Singleton02() {}

    public static Singleton02 getInstance() {
        if (instance == null) {
            synchronized (Singleton02.class) {
                // 这里要再次判断一下，因为当前线程在获取到锁之前，其他线程可能持有锁，已经将instance初始化了
                if (instance == null) {
                    instance = new Singleton02();
                }
            }
        }
        return instance;
    }
}
