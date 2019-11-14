package Thread.demo04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者-消费者 案例
 */
public class TestProductorConsumerLock {
    public static void main(String[] args) {
        ClerkLock clerk = new ClerkLock();

        ProductorLock pro = new ProductorLock(clerk);
        ConsumerLock con = new ConsumerLock(clerk);

        new Thread(pro, "生产者A").start();
        new Thread(con, "消费者B").start();
        new Thread(pro, "生产者C").start();
        new Thread(con, "消费者D").start();
    }
}

// 店员
class ClerkLock {
    private int product = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 进货
    public void get() {
        // 上锁
        lock.lock();
        try {
            while (product >= 1) { // 为了避免虚假唤醒问题，应该总是使用在循环中
                System.out.println("产品已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + ++product);
            condition.signalAll();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    // 卖货
    public void sale() {
        lock.lock();

        try {
            while (product <= 0) {
                System.out.println("缺货");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

// 生产者
class ProductorLock implements Runnable {
    private ClerkLock clerk;

    public ProductorLock(ClerkLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++) {
            clerk.get();
        }
    }
}

// 消费者
class ConsumerLock implements Runnable {
    private ClerkLock clerk;

    public ConsumerLock(ClerkLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++) {
            clerk.sale();
        }
    }
}
