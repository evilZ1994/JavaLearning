package BaseKnowledge.Thread;

public class Demo2 {
    public static void main(String[] args) {
        // 多线程常用方法

        // 1. 线程的命名与取得
        // 对于线程的名字一般在启动之前定义。不建议对启动后的线程更改名称或重名
        // 设置名字：
        // 1. 构造方法：public BaseKnowledge.Thread(Runnable target, BaseKnowledge.String name);
        // 2. 设置名字：public final void setName(BaseKnowledge.String name);
        // 3. 取得名字：public final BaseKnowledge.String getName();

        // 取得当前线程
        // public static BaseKnowledge.Thread currentThread()

        // 如果在实例化Thread对象的时候没有设置名字，那么会自动的进行编号命名
        MyThread4 mt1 = new MyThread4();
        new Thread(mt1, "线程A").start();
        new Thread(mt1).start();
        new Thread(mt1, "线程B").start();
        new Thread(mt1).start();
        // 线程A
        // 线程B
        // BaseKnowledge.Thread-0
        // BaseKnowledge.Thread-1

        // 观察：
        new Thread(mt1, "自己的线程").start();
        mt1.run();
        // 自己的线程
        // main
        // 可以看到主方法就是一个线程（主线程）

        // 每一个JVM进程启动的时候至少启动几个线程？
        // 1. 主线程
        // 2. gc线程：负责垃圾清理


        // 线程的休眠
        // 所谓的线程休眠指的就是让线程执行速度稍微变慢一点：
        // public static void sleep(long millis) throws InterruptedException

        // 线程优先级
        // 越高的优先级，越有可能先执行
        // 1. 设置优先级：public final void setPriority(int newPriority)
        // 2. 取得优先级：public final int getPriority()
        // 设置和取得优先级都是使用int数据类型，对于此内容有三种取值：
        // 1. 最高优先级：public static final int MAX_PRIORITY    10
        // 2. 中等优先级：public static final int NORMAL_PRIORITY     5
        // 3. 最低优先级：public static final int MIN_PRIORITY    1
        // 主线程属于中等优先级（5）
    }
}

class MyThread4 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
