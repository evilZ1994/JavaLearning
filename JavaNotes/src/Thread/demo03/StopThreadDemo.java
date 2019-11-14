package Thread.demo03;

class StopThread extends Thread {
    private volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开始执行");
        while (flag) {}
        System.out.println("子线程执行结束");
    }

    public void stopThread() {
        System.out.println("停止线程");
        this.flag = false;
    }
}

public class StopThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        for (int i=1; i<10; i++) {
            System.out.println("这是主线程" + i);
            Thread.sleep(1000);
            if (i == 6) {
                thread.stopThread();
            }
        }
    }
}
