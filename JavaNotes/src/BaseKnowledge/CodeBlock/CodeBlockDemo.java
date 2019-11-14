package BaseKnowledge.CodeBlock;

public class CodeBlockDemo {
    public static void main(String[] args) {
        // 可以直接使用"{}"定义一段语句
        // 分为四种：普通代码块，构造块，静态块，同步代码块(多线程时)
        // 尽量不要在代码中使用代码块

        // 普通代码块：
        // 代码块写在方法里面，称为普通代码块
        {
            int num = 10; // 局部变量，作用域仅在此代码块中
            System.out.println("NUM:" + num);
        }
        // 普通代码块是为了防止代码编写过多时可能产生的变量重名
        int num = 100;
        System.out.println("NUM:" + num);

        // 构造块：
        // 代码块写在类里面，称为构造块
        new Book(); // 打印B,A
        // 构造块执行顺序优先于构造方法

        // 静态块
        // 代码块使用static修饰，称为静态块
        // 1.在非主类中使用：
        new Book(); //打印C,B,A
        // 静态块优先于构造块执行
        // 2.在主类中使用
        System.out.println("Hello"); // 打印"World Hello"
        // 静态块优先于主方法执行
    }

    static {
        // 主方法中使用静态块
        System.out.println("World");
    }
}

class Book {
    public Book() {
        System.out.println("A");
    }

    {
        // 将代码块写在类里面，构造块
        System.out.println("B");
    }

    static {
        // 静态块
        System.out.println("C");
    }
}
