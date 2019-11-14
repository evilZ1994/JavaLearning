package BaseKnowledge.Thread;

public class ProducterAndConsumer {
    public static void main(String[] args) {
        // 生产者与消费者
        // 生产者与消费者指的是两个不同的线程类对象，操作同一资源的情况
        // 1. 生产者负责生产数据，消费者负责取走数据
        // 2. 生产者每生产完一组数据之后，消费者就要取走一组数据

        // Object类提供有等待与唤醒方法：
        // 1. 等待：public final void wait() throws InterruptedException
        // 2. 唤醒第一个等待线程：public final void notify()
        // 3. 唤醒全部等待线程，优先级高的先执行: public final void notifyAll()
        Info info = new Info();
        new Thread(new Producter(info)).start();
        new Thread(new Consumer(info)).start();

        // 面试题：请解释sleep()与wait()的区别
        // 1. sleep()是Thread类定义的方法，wait()是Object类定义的方法
        // 2. sleep()可以设置休眠时间，时间一到自动唤醒，而wait()需要等待notify()进行唤醒
    }
}

class Info {
    private String title;
    private String content;
    private boolean flag = true;
    // flag = true: 表示可以生产，但不可以取走
    // flag = false: 表示可以取走，但不可以生产

    public synchronized void set(String title, String content) {
        if (!this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;
        super.notify();
    }

    public synchronized void get() {
        if (this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.title + " - " + this.content);
        this.flag = true;
        super.notify();
    }
}

class Producter implements Runnable {
    private Info info;

    public Producter(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int x=0; x<100; x++) {
            if (x%2 == 0) {
                this.info.set("Tom", "Good Cat");
            } else {
                this.info.set("Jerry", "Smart Mouse");
            }
        }
    }
}

class Consumer implements Runnable {
    private Info info;

    public Consumer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int x=0; x<100; x++) {
            this.info.get();
        }
    }
}
