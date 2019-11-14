package BaseKnowledge.Object;

public class ObjectDemo {
    public static void main(String[] args) {
        // Object类是所有类的父类

        // 利用Object类可以接收全部类的对象，通过向上转型

        // 普通Java类通常需要覆写Object类的3个方法：
        // 1. toString()
        // 2. equals()
        // 3. hashCode()

        Book book = new Book("Java开发", 89);
        System.out.println(book.toString());
        System.out.println(book.equals(new Book("Java开发", 89)));
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
    public String toString() {
        return "Book: " + this.title + ", Price: " + this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Book) {
            Book book = (Book)obj;
            return this.title.equals(book.title) && this.price == book.price;
        }
        return false;
    }
}
