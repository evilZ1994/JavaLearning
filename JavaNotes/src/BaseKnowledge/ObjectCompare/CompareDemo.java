package BaseKnowledge.ObjectCompare;

class Book {
    private String title;
    private double price;

    public Book(String title, double price) {
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
    public boolean equals(Object obj) {
        // 复写equals()方法，自定义两个对象之间的比较逻辑
        // 方法传递本类对象，可以直接访问私有成员。比如obj.price
        return obj instanceof Book && this.title.equals(((Book) obj).title) && this.price == ((Book) obj).price;
    }
}

public class CompareDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java", 65);
        Book b2 = new Book("Java", 65);
        System.out.println(b1.equals(b2));
    }
}
