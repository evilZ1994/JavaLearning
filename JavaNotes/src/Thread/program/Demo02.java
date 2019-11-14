package Thread.program;

class MyThread2 extends Thread {
    private String result;
    private MyThread2 t;

    public MyThread2(String name) {
        this.setName(name);
    }

    public MyThread2(MyThread2 t, String name) {
        this.t = t;
        this.setName(name);
    }

    @Override
    public void run() {
        if (t != null) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.result = Thread.currentThread().getName() + " " + t.getResult();
        } else {
            this.result = Thread.currentThread().getName();
        }
    }

    public String getResult() {
        return result;
    }
}

public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 c = new MyThread2("C");
        MyThread2 b = new MyThread2(c, "B");
        MyThread2 a = new MyThread2(b, "A");
        c.start();
        b.start();
        a.start();
        a.join();
        System.out.println(c.getResult());
        System.out.println(b.getResult());
        System.out.println(a.getResult());
    }
}
