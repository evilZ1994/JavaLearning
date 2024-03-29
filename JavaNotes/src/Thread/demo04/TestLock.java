package Thread.demo04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一、用于解决多线程安全问题的方式：
 * synchronized:隐式锁
 * 1. 同步代码块
 * 2. 同步方法
 *
 * jdk1.5后：
 * 3. 同步锁Lock
 * 注意：这是一个显式锁，需要通过lock()方法上锁，通过unlock()方法释放锁
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}


class Ticket implements Runnable {
    private int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            // 上锁
            lock.lock();
            try {
                if (tick > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick);
                } else {
                    break;
                }
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}