package Thread.demo02;

class TicketThread02 implements Runnable {
    // 剩余车票数量
    private int count = 100;
    private final Object obj = new Object();

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 出售火车票
            sale();
        }
    }

    // 同步方法 使用this锁
    private synchronized void sale() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + " 出售第" + (100 - count + 1) + "张票");
            count--;
        }
    }
}

/**
 * 现在有100张火车票，有两个窗口同时抢火车票，请使用多线程模拟抢票。
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        TicketThread02 ticket = new TicketThread02();
        Thread t1 = new Thread(ticket, "售票口1");
        Thread t2 = new Thread(ticket, "售票口2");
        t1.start();
        t2.start();
    }
}
