package Thread.demo04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启3个线程，这三个线程的ID分别为A、B、C，每个线程将自己的ID打印5遍，要求输出结果必须按顺序显示
 * 如：ABCABCABC...
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlternateDemo demo = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++) {
                    demo.loopA();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++) {
                    demo.loopB();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++) {
                    demo.loopC();
                }
            }
        }, "C").start();
    }
}

class AlternateDemo {
    private int number = 1; // 当前正在执行的线程标记

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA() {
        // 上锁
        lock.lock();

        try {
            // 1. 判断
            if (number != 1) {
                condition1.await();
            }
            // 2. 打印
            System.out.print(Thread.currentThread().getName());
            // 3. 唤醒其它线程
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public void loopB() {
        // 上锁
        lock.lock();

        try {
            // 1. 判断
            if (number != 2) {
                condition2.await();
            }
            // 2. 打印
            System.out.print(Thread.currentThread().getName());
            // 3. 唤醒其它线程
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public void loopC() {
        // 上锁
        lock.lock();

        try {
            // 1. 判断
            if (number != 3) {
                condition3.await();
            }
            // 2. 打印
            System.out.print(Thread.currentThread().getName() + " ");
            // 3. 唤醒其它线程
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
