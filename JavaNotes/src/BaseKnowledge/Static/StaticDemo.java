package BaseKnowledge.Static;

class Book {
    private String title;
    private double price;
    private static String pub = "清华大学出版社";

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public static String getPub() {
        // static方法不能访问非static属性或方法
        // 非static方法可以访问static属性或方法，不受限制
        // 原因：
        // 所有的非static定义的结构，必须在类已经明确产生了实例化对象才会分配堆内存空间
        // 所有的static定义的结构，不受实例化对象的控制
        return pub;
    }

    public static void setPub(String pub) {
        Book.pub = pub;
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Java开发", 65);
        Book book2 = new Book("Python进阶", 64);
        System.out.println(book1.getPub());
        System.out.println(book2.getPub()); // 都输出 "清华大学出版社"
        System.out.println();

        book1.setPub("北京大学出版社");
        System.out.println(book1.getPub());
        System.out.println(book2.getPub()); // 都输出 "北京大学出版社"
        System.out.println();

        // 该类的所有对象共享static属性
        Book.setPub("清华大学出版社");
        System.out.println(book1.getPub());
        System.out.println(book2.getPub()); // 都输出 "清华大学出版社"
        System.out.println(Book.getPub());
        System.out.println();
        // static类型的属性不用实例化对象也能使用
        // static属性保存在全局数据区
    }
}
