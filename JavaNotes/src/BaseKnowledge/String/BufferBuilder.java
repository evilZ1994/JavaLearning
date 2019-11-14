package BaseKnowledge.String;

public class BufferBuilder {
    public static void main(String[] args) {
        // StringBuffer, StringBuilder, String的区别

        // StringBuffer
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("Hello").append(" world").append("!");
        change(sBuffer);
        System.out.println(sBuffer);  // Hello world!Java
        // StringBuffer内的内容是可变的。而String内容不可变
        // String与StringBuffer都是CharSequence接口的子类
        // CharSequence seq = "Hello";  // 向上转型

        // 将String转StringBuffer对象：
        // 1. 利用StringBuffer构造方法：public StringBuffer(BaseKnowledge.String str)
        // 2. 利用append()方法：public StringBuffer append(BaseKnowledge.String str)
        // 将StringBuffer类变为String：
        // 1. 利用toString()方法
        // 2. 利用String类的构造方法：public BaseKnowledge.String(StringBuffer sb)

        // String类里面也提供有一个和StringBuffer比较的方法：public boolean contentEquals(StringBuffer sb)
        System.out.println("Hello".contentEquals(sBuffer));

        // StringBuffer定义的一些常用方法：
        // 1. 字符串反转：public StringBuffer reverse()
        // 2. 在指定索引位置增加数据：public StringBuffer insert(int index, 数据)
        System.out.println(sBuffer.insert(5, "Python"));  // HelloPython world!Java
        // 3. 删除部分数据：public StringBuffer delete(int start, int stop)
        System.out.println(sBuffer.delete(5, 11));  // Hello world!Java

        // 从JDK1.5之后添加了一个新的字符串操作类：StringBuilder
        // 观察文档可以发现：StringBuffer类与StringBuilder类在定义上非常相似，几乎连方法也一样
        // 观察源代码可以发现：StringBuffer类定义的方法有synchronized声明，而StringBuilder定义的方法则没有
        // 面试题：解释String, StringBuffer, StringBuilder的区别：
        // 1. String的内容一旦声明则不可改变，而StringBuffer与StringBuilder声明的内容可以改变
        // 2. StringBuffer类中提供的方法都是同步方法，属于安全的线程操作，而StringBuilder提供的方法都是异步方法，属于非线程安全的操作
    }

    public static void change(StringBuffer buffer) {
        buffer.append("Java");
    }
}
