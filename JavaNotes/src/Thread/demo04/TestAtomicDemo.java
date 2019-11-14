package Thread.demo04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一、 i++的原子性问题： i++ 的操作实际上分为三个步骤"读-改-写"
 *      int i = 0;
 *      i = i++; // 10
 *      ---------------
 *      // 在操作底层相当于
 *      int temp = i;
 *      i = i + 1;
 *      i = temp;
 *
 * 二、 使用java.util.concurrent.atomic 包下的原子变量 AtomicInteger
 * 原子变量的原理：
 *      - volatile	保证内存可见性
 *      - CAS(Compare-And-Swap)算法  保证数据的原子性
 *          - CAS算法是硬件对并发操作共享数据的支持针对多处理器 操作而设计的处理器中的一种特殊指令，用于管理对共享数据的并 发访问。
 *          - CAS 是一种无锁的非阻塞算法的实现。
 *          - CAS包含了三个操作数：
 *              - 内存值 V （需要读写的内存值）
 *              - 预估值 A （进行比较的值）
 *              - 更新值 B （拟写入的新值）
 *              - 当且仅当V == A时，V = B。否则，将不做任何操作。
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i=0; i<10; i++) {
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable {
    private int serialNumber = 0;
    // 使用原子变量
    private AtomicInteger serialNumberAtomic = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + getSerialNumber() + " " + getSerialNumberAtomic());
    }

    private int getSerialNumber() {
        return serialNumber++;
    }

    private int getSerialNumberAtomic() {
        // 使用原子变量的自增运算
        return serialNumberAtomic.incrementAndGet();
    }
}
