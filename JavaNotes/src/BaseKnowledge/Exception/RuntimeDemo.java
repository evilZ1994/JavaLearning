package BaseKnowledge.Exception;

import java.io.IOException;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Runtime类
        // 在每一个JVM进程里面都会存在有一个Runtime类的对象，这个类的主要功能是取得一些运行时有关的环境属性或者创建新的进程等操作
        // 在Runtime类定义的时候，它的构造方法已经私有化了。这就属于单例设计模式的应用，因为要保证在整个进程里面只有唯一的一个Runtime类的对象
        // 所以在Runtime里提供有一个静态方法，用于取得当前Runtime类的实例化对象：
        // public static RuntimeDemo getRuntime()
        Runtime runtime = Runtime.getRuntime();

        // Runtime类是直接与本地运行有关的所有相关属性的集合，所有Runtime类中定义有如下方法：
        // 1. 返回可用内存空间：public long totalMemory()
        // 2. 返回最大内存空间：public long maxMemory()
        // 3. 返回空余内存空间：public long freeMemory()

        // Runtime类有一个方法可以释放垃圾空间：public void gc()

        // 面试题：请解释什么叫GC？如何处理？
        // 1. GC(Garbage Collector)垃圾收集器，指的是释放无用的内存空间
        // 2. GC会由系统不定期进行自动回收，或者调用Runtime类的gc()方法手工回收

        // Runtime还有一个功能，它可以调用本机的可执行程序，并创建进程：
        // 执行程序：public Process exec(BaseKnowledge.String command) throws IOException
//        Process pro = runtime.exec("mspaint.exe");  // 调用画图程序
//        BaseKnowledge.Thread.sleep(2000);
//        pro.destroy();  // 销毁进程

        // 总结：
        // 1. Runtime类使用了单例设计模式，必须通过内部的getRuntime()方法取得Runtime的实例化对象
        // 2. Runtime类提供了gc()方法，可以用于手工释放内存
    }
}
