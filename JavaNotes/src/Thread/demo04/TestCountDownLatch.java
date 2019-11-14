package Thread.demo04;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: 闭锁，在完成某些运算时，只有其他线程的运算全部完成，当前线程的运算才继续执行
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        // count参数设置为5（这里对应于下面我们要开启的5个线程）
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(latch);

        long start = System.currentTimeMillis();
        for (int i=0; i<5; i++) {
            // 每执行完一个线程，就在线程中将latch的count递减1
            new Thread(latchDemo).start();
        }

        try {
            // 以上子线程未执行完成（闭锁未递减到0），主线程等待
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 直到latch的count递减为0，说明所有线程执行完毕，可以统计这几个线程的执行时间了
        long end = System.currentTimeMillis();

        System.out.println("执行时间为：" + (end - start));
    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<5000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            // 当前线程执行完成，调用countDown()方法，闭锁中的count递减1
            latch.countDown();
        }

    }
}