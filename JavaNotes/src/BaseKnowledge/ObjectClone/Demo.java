package BaseKnowledge.ObjectClone;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 对象克隆
        // Object类里提供有一个专门的克隆方法：
        // protected BaseKnowledge.Object clone() throws CloneNotSupportException
        // protected声明的方法：同包或不同包的子类才能访问
        // 如果克隆的对象的类没有实现Cloneable接口就会抛出异常
        // 但是Cloneable接口看不见方法，表示这是一个标识接口

        Book bookA = new Book("Java开发", 80);
        Book bookB = (Book) bookA.clone();
        bookB.setTitle("Python开发");
        System.out.println(bookA);
        System.out.println(bookB);
    }
}

class Book implements Cloneable { // 此类的对象可以被克隆
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book Name:" + this.title + " Price:" + this.price;
    }

    // 由于此类需要对象克隆操作，所需才需要进行方法的覆写
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 调用父类的克隆方法
    }
}
