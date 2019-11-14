package BaseKnowledge.This;


class Book {
    private String title;
    private double price;

    public Book() {
        System.out.println("A new Book created");
    }

    public Book(String title) {
        // this表示当前对象
        // this可以相互调用构造方法，但是必须写在方法内的第一行
        this();  // 调用无参构造
        this.setTitle(title);
    }

    public Book(String title, double price) {
        this(title); // 调用单参构造
        this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public String getInfo() {
        return "BOOK:" + title + " PRICE:" + price;
    }
}

public class ThisDemo {
    public static void main(String[] args) {
        Book book = new Book("Java", 68);
        System.out.println(book.getInfo());
    }
}
