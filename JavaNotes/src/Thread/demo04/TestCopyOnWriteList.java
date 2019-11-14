package Thread.demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * CopyOnWriteArrayList "写入并复制"
 */
public class TestCopyOnWriteList {
    public static void main(String[] args) {
        for (int i=0; i<5; i++) {
            new Thread(new ListThread()).start();
        }
    }
}

class ListThread implements Runnable {
    // 在迭代时添加元素会出现并发修改异常
    //  private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    // 由于每次写入时都会进行复制，不会出现并发修改异常
    // 但是添加操作多时，效率低下。在需要并发操作时使用。
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add("DDD");
        }
    }
}
