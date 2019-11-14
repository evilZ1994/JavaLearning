package Thread.demo01;

/**
 * 现在有T1、T2、T3三个线程，怎样保证T2在T1执行完后执行，T3在T2执行完后执行。
 */
public class P1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++) {
                    System.out.println("T1 run " + i);
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 将t1线程加入，让t1线程优先执行
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i=0; i<5; i++) {
                    System.out.println("T2 run " + i);
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 将t2线程加入，让t2线程优先执行
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i=0; i<5; i++) {
                    System.out.println("T3 run " + i);
                }
            }
        });
        t3.start();
    }
}
