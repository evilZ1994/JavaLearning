package Thread.demo01;

class MyThread01 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<30; i++) {
            System.out.println("run: " + i);
        }
    }
}

class MyThread02 implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<30; i++) {
            System.out.println("run: " + i);
        }
    }
}

public class ThreadDemo01 {
    /**
     * 创建线程的方式
     * 1. 继承Thread类
     * 2. 实现Runnable接口
     * 3. 使用匿名内部类
     * 4. 实现Callable接口
     * 5. 使用线程池创建
     */
    public static void main(String[] args) {
        // 1.继承Thread类
        // 创建线程
        MyThread01 t1 = new MyThread01();
        // 启动线程
        t1.start();

        // 2.实现Runnable
        // 创建线程
        Thread t2 = new Thread(new MyThread02());
        // 启动线程
        t2.start();

        // 3.匿名内部类
        // 创建线程
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<30; i++) {
                    System.out.println("run: " + i);
                }
            }
        });
        // 启动线程
        t3.start();
    }
}
