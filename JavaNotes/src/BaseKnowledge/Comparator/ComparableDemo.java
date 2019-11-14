package BaseKnowledge.Comparator;

import java.util.Arrays;

public class ComparableDemo {
    public static void main(String[] args) {
        // 比较器：Comparable接口

        // Arrays类中提供的数组排序方法：
        // 对象数组排序：public static void sort(BaseKnowledge.Object[] a)
        // 数组中的对象必须实现Comparable接口
        // 覆写compareTo()方法，大于返回1，小于返回-1，等于返回0
        Book[] books = new Book[] {
            new Book("Java开发", 80),
            new Book("Python开发", 60),
            new Book("Android开发", 75)
        };
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));
    }
}

class Book implements Comparable<Book>{
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：" + this.title + " 价格：" + this.price;
    }

    @Override
    public int compareTo(Book o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return 0;
        }
    }
}
