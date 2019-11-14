package Thread.demo01;

public class ThreadDemo03 {

    /**
     * 用户线程属于非守护线程，和主线程互不影响
     * 守护线程会随着主线程一同被销毁
     */
    public static void main(String[] args) {
        // 非守护线程
        Thread userThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<20; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("User Thread: " + i);
                }
            }
        });
//        userThread.start();

        // 守护线程
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<20; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Daemon Thread: " + i);
                }
            }
        });
        daemonThread.setDaemon(true); // 设置为守护线程
        // 测试守护线程时，把上面用户线程的启动注释掉，否则用户线程未结束的话，守护线程也不会结束
        daemonThread.start();

        // 主线程
        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main Thread: " + i);
        }
        System.out.println("Main Thread Execute Done!");
    }
}
