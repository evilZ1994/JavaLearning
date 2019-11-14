package DesignPattern.Proxy.Static;

/**
 * 静态代理类实现被代理类的接口
 */
public class SingerProxy implements ISinger {
    private ISinger target;

    public SingerProxy(ISinger target) {
        this.target = target;
    }

    @Override
    public void sing() {
        System.out.println("Before Singing !");
        target.sing();
        System.out.println("After Singing !");
    }
}
