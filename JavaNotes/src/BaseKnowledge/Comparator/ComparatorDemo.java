package BaseKnowledge.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        // Comparable接口是在定义类的时候实现的
        // 如果有一个类已经开发完成，后来想增加对象数组排序的功能
        // 在不修改原类的情况下，是不能使用Comparable接口的
        // 为了解决这个问题，Java提供了一个比较器：java.util.BaseKnowledge.Comparator

        // 原本在Comparator接口下定义了两个方法：
        // public int compare(T o1, T o2)
        // public boolean equals(BaseKnowledge.Object obj)

        // 要真正实现的只有compare()方法，需要单独准备出一个类来实现Comparator接口
        // Arrays的排序方法有一个：public static void sort(T[] a, BaseKnowledge.Comparator<? super T> c)
        Book2[] books = new Book2[] {
                new Book2("Java开发", 80),
                new Book2("Python开发", 60),
                new Book2("Android开发", 75)
        };
        Arrays.sort(books, new BookComparator());
        System.out.println(Arrays.toString(books));

        // Comparable和Comparator的区别
        // java.lang.Comparable是在一个类定义的时候实现好的接口，这样本类的对象数组就可以实现排序方法：compareTo()
        // java.util.Comparator是专门定义一个类的比较器。属于挽救的比较操作。里面有两个方法compare()和equals()
    }
}

class Book2 {
    private String title;
    private double price;

    public Book2(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "书名：" + this.title + " 价格：" + this.price;
    }
}

class BookComparator implements Comparator<Book2> {

    @Override
    public int compare(Book2 o1, Book2 o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}
