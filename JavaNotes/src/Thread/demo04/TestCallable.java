package Thread.demo04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 一、 创建执行线程的方式三：实现Callable接口
 * 相较于实现Runnable，Callable方法可以有返回值，而且可以抛出异常
 * 二、 执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果; FutureTask是Future接口的实现类
 */
public class TestCallable {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        // 1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
        FutureTask<Integer> futureTask = new FutureTask<>(threadDemo);
        new Thread(futureTask).start();
        // 2.接收线程运算后的结果
        try {
            // 线程未执行完成时，这里不会被执行
            // 因此FutureTask也可用于闭锁
            int sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThreadDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=0; i<100; i++) {
            sum += i;
        }
        return sum;
    }
}