package Thread.demo04;

/**
 * 模拟CAS算法
 */
public class TestCompareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();
        for (int i=0; i<10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectValue = cas.get();
                    boolean b = cas.compareAndSet(expectValue, (int)(Math.random()*100));
                    System.out.println(b);
                }
            }).start();
        }
    }
}

class CompareAndSwap {
    private int value;

    // 获取内存值
    public synchronized int get() {
        return value;
    }

    // 比较
    public synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = this.value;
        if (oldValue == expectValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    // 设置
    public synchronized boolean compareAndSet(int expectValue, int newValue) {
        return expectValue == compareAndSwap(expectValue, newValue);
    }
}
