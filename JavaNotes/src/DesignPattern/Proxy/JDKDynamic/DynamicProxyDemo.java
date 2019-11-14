package DesignPattern.Proxy.JDKDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理实现代理模式
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        ISinger target = new Singer();
        // 代理对象
        ISinger proxy = (ISinger) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Before Singing !");
                // 执行目标方法
                Object obj = method.invoke(target, args);
                System.out.println("After Singing !");
                return obj;
            }
        });
        proxy.sing();
    }
}
