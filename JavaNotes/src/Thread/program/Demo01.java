package Thread.program;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<String> {
    private FutureTask<String> futureTask;

    public MyThread() {}

    public MyThread(FutureTask<String> futureTask) {
        this.futureTask = futureTask;
    }

    @Override
    public String call() throws Exception {
        if (this.futureTask != null) {
            return Thread.currentThread().getName() + " " + futureTask.get();
        }
        return Thread.currentThread().getName();
    }
}

public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread c = new MyThread();
        FutureTask<String> fc = new FutureTask<>(c);
        MyThread b = new MyThread(fc);
        FutureTask<String> fb = new FutureTask<>(b);
        MyThread a = new MyThread(fb);
        FutureTask<String> fa = new FutureTask<>(a);
        new Thread(fa, "A").start();
        new Thread(fb, "B").start();
        new Thread(fc, "C").start();
        System.out.println(fc.get());
        System.out.println(fb.get());
        System.out.println(fa.get());
    }
}
