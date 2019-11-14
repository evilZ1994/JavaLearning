package BaseKnowledge.Thread;

public class Demo3 {
    public static void main(String[] args) {
        // 同步与死锁
        // 首先观察非同步：
//        MyThread5 mt1 = new MyThread5();
//        new BaseKnowledge.Thread(mt1, "BaseKnowledge.Thread A").start();
//        new BaseKnowledge.Thread(mt1, "BaseKnowledge.Thread B").start();
//        new BaseKnowledge.Thread(mt1, "BaseKnowledge.Thread C").start();
//        new BaseKnowledge.Thread(mt1, "BaseKnowledge.Thread D").start();
        // 此时的操作出现负数

        // 同步操作
        // synchronized关键字
        // 1. 使用同步代码块: synchronized(obj){}
        // 2. 使用同步方法
        MyThread6 mt2 = new MyThread6();
        new Thread(mt2, "BaseKnowledge.Thread A").start();
        new Thread(mt2, "BaseKnowledge.Thread B").start();
        new Thread(mt2, "BaseKnowledge.Thread C").start();
        new Thread(mt2, "BaseKnowledge.Thread D").start();
    }
}

class MyThread5 implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        for (int x=0; x<20; x++) {
            if (this.ticket > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + this.ticket--);
            }
        }
    }
}

// 同步线程示例
class MyThread6 implements Runnable {
    private int ticket = 8;

    @Override
    public void run() {
        for (int x=0; x<3; x++) {
            // 同步代码块，锁住当前对象
            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + this.ticket--);
                }
            }

            // 调用同步方法
            // this.sale();
        }
    }

    // 同步方法
    public synchronized void sale() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + this.ticket--);
        }
    }
}
