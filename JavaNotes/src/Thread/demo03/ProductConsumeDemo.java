package Thread.demo03;

/**
 * 共享资源
 */
class Res {
    // true时生产者线程等待，消费者可以消费；false时生产者线程生产，消费者等待
    public boolean flag = false;
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
            synchronized (res) {
                if (res.flag) {
                    try {
                        // 让当前线程从运行状态变为休眠状态，并释放锁的资源
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                res.notify();
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
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + " " + res.sex);
                res.flag = false;
                res.notify();
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
