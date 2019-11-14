package DesignPattern.Proxy.Static;

/**
 * 静态代理示例：
 * 缺点：这种实现方式很直观也很简单，但其缺点是代理对象必须提前写出，如果接口层发生了变化，代理对象的代码也要进行维护。
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        ISinger target = new Singer();
        // 代理对象
        ISinger proxy = new SingerProxy(target);
        proxy.sing();
    }
}


