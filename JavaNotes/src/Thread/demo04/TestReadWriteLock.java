package Thread.demo04;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock：读写锁
 * 写写/读写 需要"互斥"
 * 读读 不需要"互斥"
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        // 写线程
        new Thread(() -> demo.set((int)(Math.random() * 101)), "Writer").start();

        for (int i=0; i<10; i++) {
            // 读线程
            new Thread(demo::get, "Reader").start();
        }
    }
}

class ReadWriteLockDemo {
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // 读
    public void get() {
        // 上锁 （读锁）
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            // 释放锁
            lock.readLock().unlock();
        }
    }

    // 写
    public void set(int number) {
        // 上锁 （写锁）
        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        } finally {
            // 释放锁
            lock.writeLock().unlock();
        }
    }
}