package Thread.demo03.LockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源
 */
class Res {
    // true时生产者线程等待，消费者可以消费；false时生产者线程生产，消费者等待
    public boolean flag = false;
    // 并发包下的Lock锁
    public Lock lock = new ReentrantLock();
    // 用于控制lock锁的线程休眠与唤醒。（其方法await()和signal()类似于Object类的wait()和notify()）
    public Condition condition = lock.newCondition();
    public String name;
    public String sex;
}

class Product extends Thread {
    Res res;

    public Product(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                // 开始上锁
                res.lock.lock();
                if (res.flag) {
                    // 当前线程等待并释放锁（类似于wait()方法）
                    res.condition.await();
                }
                if (count == 0) {
                    res.name = "小明";
                    res.sex = "男";
                } else {
                    res.name = "小红";
                    res.sex = "女";
                }
                count = (count + 1) % 2;
                res.flag = true;
                // 唤醒等待锁的线程（类似于notify()方法）
                res.condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                res.lock.unlock();
            }
        }
    }
}

class Consumer extends Thread {
    Res res;

    public Consumer(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 开始上锁
                res.lock.lock();
                if (!res.flag) {
                    // 当前线程等待并释放锁（类似于wait()方法）
                    res.condition.await();
                }
                System.out.println(res.name + " " + res.sex);
                res.flag = false;
                // 唤醒等待锁的线程（类似于notify()方法）
                res.condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}

public class ProductConsumeDemo {
    public static void main(String[] args) {
        Res res = new Res();
        Product product = new Product(res);
        Consumer consumer = new Consumer(res);
        product.start();
        consumer.start();
    }
}
