package BaseKnowledge.Set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // List子接口
        // 常用子类：ArrayList, Vector

        // List接口对Collection的功能进行了一些扩充
        // 主要掌握以下方法：
        // public E get(int index)
        // public E set(int index, E element)
        // public ListIterator<E> listIterator()

        // 子类：ArrayList
        List<String> all = new ArrayList<>();
        all.add("Hello");
        all.add("World");
        all.add("!");
        System.out.println(all.isEmpty());
        for (int i=0; i<all.size(); i++) {
            System.out.println(all.get(i));
        }
        Iterator<String> iterator = all.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (String str : all) {
            System.out.println(str);
        }

        // ArrayList与Vector的区别
        // 1. 推出时间：JDK1.2 属于新的类       JDK1.0 属于旧的类
        // 2. 性能：    异步处理               同步处理
        // 3. 安全性：  非线程安全              线程安全
        // 4. 输出:     Iterator, ListIterator, foreach       Iterator, ListIterator, foreach, Enumeration

    }
}
