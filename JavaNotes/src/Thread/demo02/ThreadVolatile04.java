package Thread.demo02;

class VolatileThread extends Thread {
    private volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开启");
        while (flag) {
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running");
        }
        System.out.println("子线程结束");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class ThreadVolatile04 {
    public static void main(String[] args) throws InterruptedException {
        VolatileThread thread = new VolatileThread();
        thread.start();
        Thread.sleep(1000);
        thread.setFlag(false);
        Thread.sleep(1000);
    }
}
