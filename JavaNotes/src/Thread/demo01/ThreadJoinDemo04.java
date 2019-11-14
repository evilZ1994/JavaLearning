package Thread.demo01;

public class ThreadJoinDemo04 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<30; i++) {
                    System.out.println("thread run " + i);
                }
            }
        });
        thread.start();
        // 主线程让子线程先执行完，再执行
        try {
            // 调用join()方法
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0; i<10; i++) {
            System.out.println("main " + i);
        }
    }
}
