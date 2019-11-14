package BaseKnowledge.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 多线程
        // 1. 继承Thread类
        // 2. 实现Runnable接口(Callable接口）

        // Thread类
        Thread threadA = new MyThread("线程A");
        Thread threadB = new MyThread("线程B");
        Thread threadC = new MyThread("线程C");
        threadA.start();
        threadB.start();
        threadC.start();
        // 每个线程对象交替执行

        // Runnable接口
        MyThread2 threadD = new MyThread2("线程D");
        MyThread2 threadE = new MyThread2("线程E");
        MyThread2 threadF = new MyThread2("线程F");
        new Thread(threadD).start();
        new Thread(threadE).start();
        new Thread(threadF).start();
        // 实现Runnable接口只覆写了run方法，没有start方法
        // 但是Thread类的构造方法接收一个Runnable类型的对象
        // 因此可以将实现了Runnable接口的实例传入Thread类来启动多线程

        // 首先明确，使用Runnable接口与继承Thread类相比，解决了单继承的局限，所以尽量使用Runnable接口

        // Thread类的定义：
        // public class BaseKnowledge.Thread extends BaseKnowledge.Object implements Runnable

        // Runnable接口实现了数据共享的概念
        //        BaseKnowledge.Thread threadA = new MyThread("线程A");
        //        BaseKnowledge.Thread threadB = new MyThread("线程B");
        //        BaseKnowledge.Thread threadC = new MyThread("线程C");
        //        threadA.start();
        //        threadB.start();
        //        threadC.start();
        // 这是继承Thread类，新建了三个线程对象，它们各自有各自的内存空间
        // MyThread2 threadD = new MyThread2("线程D");
        // new BaseKnowledge.Thread(threadD).start();
        // new BaseKnowledge.Thread(threadD).start();
        // new BaseKnowledge.Thread(threadD).start();
        // 用Runnable接口实现，虽然这里新建了3个线程对象，但是它们都占用了同一个threadD，这三个线程对象都直接访问同一个数据资源

        // 继承Thread类和实现Runnable接口的区别：
        // 1. Thread类是Runnable接口的子类，使用Runnable接口实现多线程可以避免单继承的局限
        // 2. Runnable接口实现的多线程可以比Thread类实现的多线程更加清除的描述数据共享的概念


        // Callable接口
        // 使用Runnable接口实现的多线程不能返回操作结果
        // @FunctionalInterface
        // public interface Callable<V> {
        //      public V call() throws BaseKnowledge.Exception;
        // }
        // Thread类的构造方法中并没有接收Callable对象的方法
        // 从JDK1.5开始提供有java.util.concurrent.FutureTask<V>类。这个类主要是Callable接口对象操作的
        // public class FutureTask<V> extends BaseKnowledge.Object implements RunnableFuture<V>
        // public interface RunnableFuture<V> extends Runnable, Future<V>
        // 在FutureTask类定义的构造方法有接收Callable对象
        MyThread3 mtA = new MyThread3();
        MyThread3 mtB = new MyThread3();
        FutureTask<String> task1 = new FutureTask<>(mtA);
        FutureTask<String> task2 = new FutureTask<>(mtB);
        new Thread(task1).start();
        new Thread(task2).start();
        System.out.println(task1.get());
        System.out.println(task2.get());
    }
}

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int x=0; x<10; x++) {
            System.out.println(name + "-->" + x);
        }
    }
}

class MyThread2 implements Runnable {
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int x=0; x<10; x++) {
            System.out.println(name + "-->" + x);
        }
    }
}

class MyThread3 implements Callable<String> {
    private int ticket = 10;
    @Override
    public String call() {
        for (int i=0; i<100; i++) {
            if (this.ticket > 0) {
                System.out.println("ticket:" + ticket--);
            }
        }
        return "Sold out";
    }
}
