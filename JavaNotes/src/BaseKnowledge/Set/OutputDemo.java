package BaseKnowledge.Set;

import java.util.*;

public class OutputDemo {
    public static void main(String[] args) {
        // 集合的输出

        // 迭代输出：Iterator（核心）
        // public boolean hasNext()
        // public E next()
        List<String> li = new ArrayList<>();
        li.add("A");
        li.add("B");
        li.add("C");
        Iterator<String> iterator = li.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // Iterator本身指具备由前向后的输出
        // 可以使用Iterator的子接口--ListIterator，可实现由后往前的输出
        // ListIterator
        // 1. 判断是否有前一个元素：public boolean hasPrevious()
        // 2. 取得元素：public E previous()
        // ListIterator是专门为List接口定义的输出接口
        ListIterator<String> listIterator = li.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        // ListIterator在进行由后向前迭代之前，必须先进行由前向后的迭代
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // foreach输出
        for (String str : li) {
            System.out.println(str);
        }

        // Enumeration输出
        // 1. 判断是否有下一个元素：public boolean hasMoreElements()
        // 2. 取出元素：public E nextElement();
        Vector<String> vector = new Vector<>();
        vector.add("X");
        vector.add("Y");
        vector.add("Z");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
