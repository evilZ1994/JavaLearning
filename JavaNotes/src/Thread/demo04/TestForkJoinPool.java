package Thread.demo04;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 1000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;

    private static final long THRESHOLD = 10000L; // 临界值

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        long sum = 0L;
        if (length <= THRESHOLD) {
            for (long i=start; i<=end; i++) {
                sum += i;
            }
        } else {
            long middle = (start + end) / 2;
            // 进行拆分，并同时压入线程队列
            ForkJoinSumCalculate leftFork = new ForkJoinSumCalculate(start, middle);
            leftFork.fork();
            ForkJoinSumCalculate rightFork = new ForkJoinSumCalculate(middle + 1, end);
            rightFork.fork();

            // 将结果进行合并
            return leftFork.join() + rightFork.join();
        }
        return sum;
    }
}
