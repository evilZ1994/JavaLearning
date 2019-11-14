package BaseKnowledge.Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // Set接口
        // Set并没有扩充Collection接口的方法，只是继承

        // Set接口下有两个常用子类：HashSet, TreeSet

        // HashSet
        Set<String> all = new HashSet<>();
        all.add("Hello");
        all.add("Hello");
        all.add("World");
        all.add("!");
        System.out.println(all); // [!, Hello, World]
        // Set集合下没有重复元素（这是Set接口的特征）
        // HashSet里面保存的数据是无序的，即：HashSet子类的特征属于无序排列

        // TreeSet
        Set<String> tree = new TreeSet<>();
        tree.add("B");
        tree.add("A");
        tree.add("A");
        tree.add("C");
        System.out.println(tree);  // [A, B, C]
        // TreeSet集合下没有重复数据，而且保存的内容自动排序

        // TreeSet集合保存对象时，对象的类必须实现Comparable接口（用于排序）
        // TreeSet主要依靠Comparable接口中compareTo()方法判读是否是重复数据，如果返回是0，就表示是重复数据

        // 关于重复元素
        // Comparable接口只负责TreeSet子类进行重复元素的判读，并不是真正判断重复元素的操作
        // 要判断重复元素，只能够依靠Object类中提供的方法：
        // 1. 取得哈希码：public int hashCode()
        //      先判断对象的哈希码是否相同，依靠哈希码取得一个对象的内容
        // 2. 对象比较：public boolean equals(BaseKnowledge.Object obj)
        //      再将对象的属性依次进行比较
        Set<Book> bookSet = new HashSet<Book>();
        bookSet.add(new Book("Java开发", 80));
        bookSet.add(new Book("Java开发", 80));
        bookSet.add(new Book("Python开发", 90));
        bookSet.add(new Book("PHP开发", 70));
        System.out.println(bookSet);  // 没有重复

        // 在非排序的情况下，只要是判断重复元素依靠的永远是hashCode()与equals()
    }
}

class Book {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, price);
    }
}
