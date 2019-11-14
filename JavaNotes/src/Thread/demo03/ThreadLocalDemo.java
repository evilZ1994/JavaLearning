package Thread.demo03;

class ResEntity {
    // 声明一个保存Integer类型的ThreadLocal对象（初始值为0）
    private ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            // 初始化方法
            return 0;
        }
    };

    public int getValue() {
        // 获取当前线程的局部变量ThreadLocal对象的值
        int val = local.get();
        // 更新ThreadLocal的值
        local.set(val + 1);
        return val;
    }
}

class LocalThread extends Thread {
    private ResEntity res;

    public LocalThread(ResEntity res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            System.out.println(getName() + " " + res.getValue());
        }
    }
}

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ResEntity res = new ResEntity();
        // 这三个线程虽然持有同一个对象res，但是局部变量ThreadLocal的操作是针对每一个线程单独处理
        LocalThread t1 = new LocalThread(res);
        LocalThread t2 = new LocalThread(res);
        LocalThread t3 = new LocalThread(res);
        t1.start();
        t2.start();
        t3.start();
    }
}
