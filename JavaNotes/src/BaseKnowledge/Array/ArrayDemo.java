package BaseKnowledge.Array;

public class ArrayDemo {
    public static void main(String[] args) {
        // 数组定义：
        // 1.声明并开辟数组
        int a[] = new int[10];
        int[] b = new int[10];
        // 2.分步完成，先声明，后开辟
        int c[] = null;
        c = new int[10];
        // 以上是动态初始化，数组首先会开辟内存，设置相应数据类型的默认值
        // 数组初始化时在堆内存中开辟连续的空间
        for (int i=0; i<a.length; i++) {
            System.out.println(a[0]); // 输出0；默认初始化为0
        }
        // 静态初始化
        int d[] = new int[]{1, 2, 3, 4};
        int e[] = {1, 2, 3, 4, 5}; // 不建议

        // 二维数组
        // 动态初始化
        int f[][] = new int[2][4];
        // 静态初始化
        int g[][] = new int[][]{
                {1, 2, 3, 4},
                {3, 4, 5, 6}
        };


        // 对象数组
        // 动态初始化
        Book books1[] = new Book[3]; // 默认初始化为null
        // 静态初始化
        Book books2[] = new Book[] {new Book("Java开发", 69), new Book("Python进阶", 70)};
    }
}

class Book {
    private String title;
    private int price;

    public Book(String t, int p) {
        this.title = t;
        this.price = p;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
