package BaseKnowledge.System;

public class SystemDemo {
    public static void main(String[] args) {
        // System类

        // 取得当前的系统时间
        // public static long currentTimeMillis()
        // 可用于统计某个操作执行所花费的时间
        long start = System.currentTimeMillis();
        for (int i=0; i<1000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time costs:" + (end - start));

        // System类定义了一个gc方法：
        // public static void gc()
        // 这个方法等价于 Runtime.getRuntime().gc()

        // 如果一个对象将被销毁，而需要做一些销毁前的收尾工作，那么可以覆写Object类的finalize()方法
        // protected void finalize() throws Throwable
        // 在对象回收时就算抛出了任何异常，也不会影响程序的执行
    }
}
