package BaseKnowledge.Enumerate;

public class Demo {
    public static void main(String[] args) {
        // 枚举
        Color red = Color.RED;
        // 用enum定义的枚举相当于是继承了Enum类
        // Enum定义了一些方法
        int index = red.ordinal(); // 取得枚举的索引
        String name = red.name(); // 取得枚举的名字
        Color[] colors = Color.values(); // 取得所有的枚举对象

        // 面试题：解释enum和Enum的区别：
        // 1. enum是一个关键字，而Enum是一个抽象类
        // 2. 用enum定义的枚举相当于一个类继承了Enum这个抽象类

        // 枚举相当于实现了多例设计
        for (Color2 c : Color2.values()) {
            System.out.println(c.toString());
        }
    }
}

enum Color {
    RED, GREEN, BLUE
}

/**
 * 枚举也能定义属性和方法
 */
enum Color2 {
    RED("红色"), GREEN("绿色"), BLUE("蓝色");

    private String title; // 属性
    // 构造方法私有化
    private Color2(String title) {
        this.title = title;
    }

    public String toString() {
        return this.title;
    }
}
