package Thread.demo01;

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<20; i++) {
            // getId() 获取线程ID
            System.out.println("线程id:" + getId() + " run: " + i);

            // 线程休眠
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<20; i++) {
            System.out.println("线程id: " + Thread.currentThread().getId() + "线程名：" + Thread.currentThread().getName());
            System.out.println("run: " + i);
            // 线程休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo02 {
    /**
     * 常用的线程API和方法
     */
    public static void main(String[] args) {
        // 获取主线程ID和名字
        System.out.println("主线程id：" + Thread.currentThread().getId() + " 名称："  + Thread.currentThread().getName());
        for (int i=0; i<3; i++) {
            Thread thread = new MyThread1();
            thread.start();
        }

        Thread t2 = new Thread(new MyThread2(), "MyThread2");
        t2.start();
    }
}
