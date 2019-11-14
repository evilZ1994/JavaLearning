package Thread.demo04;

import java.util.Random;
import java.util.concurrent.*;

public class TestScheduledThreadPool {
    public static void main(String[] args) {
        // 1. 创建线程池
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        // 2. 分配定时任务
        for (int i=0; i<5; i++) {
            Future<Integer> future = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " " + num);
                    return num;
                }
            }, 2, TimeUnit.SECONDS);  // 设置为延迟2秒
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 3. 关闭线程池
        pool.shutdown();
    }
}
