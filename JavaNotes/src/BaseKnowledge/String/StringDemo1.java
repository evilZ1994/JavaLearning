package BaseKnowledge.String;

public class StringDemo1 {
    public static void main(String[] args) {
        // BaseKnowledge.String 的两种实例化方式
        // 1.直接赋值
        String str1 = "Hello world";
        // 2.构造方法实例化
        String str2 = new String("Hello world");

        // String比较
        String str3 = "Hello world";
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // true
        // 原因：== 符号比较的是字符串在堆内存中的地址
        // 直接赋值方式 "Hello world"这个字符串是在堆内存中，str1和str3都指向了它
        // 而用构造方法实例化时，new关键字会在堆内存中开辟一个新的空间，然后赋值为"Hello world"

        // 注意：
        // 字符串内容比较，使用equals()方法
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1.equals(str3)); // true

        // 字符串常量就是String的匿名对象
        System.out.println("Hello world".equals(str2)); // true
        // 字符串不属于基本数据类型

        // 字符串比较时，将匿名对象写在前面
        // 避免空指针异常
        String input = null; // 如果接受的用户输入为空
        if ("Hello".equals(input)) {
            // 如果用input调用equals()方法，则有可能会出现空指针异常
            // 匿名字符串对象则永远不会为空
            System.out.println("OK");
        }

        // 共享设计模式
        // JVM底层实际上存在一个对象池（不一定是保存String对象）
        // 当使用直接赋值的方式定义了一个String对象时，会将此匿名对象入池保存，如果后续还有其他String类对象使用直接赋值的方式，
        // 并且设置了同样的内容，那么将不会开辟新的内存空间，而是使用已有的对象进行引用分配，从而继续使用。

        // 使用构造方法实例化时，首先堆内存中会开辟一块堆内存空间保存匿名对象，然后开辟新的内存空间保存新对象的值（和匿名对象的值相同）
        // 如果匿名对象没有使用，则会成为垃圾，不会自动入池（但用户可以使用intern()方法手动入池）
        // 因此不推荐使用构造方法实例化字符串对象

        // 字符串常量一旦定义则不可改变
        String str = "Hello";
        str = str + "World";
        // 这里其实字符串常量的内容并没有改变，String类对象内容的改变其实是依靠引用变更改变的
        // 整个内存分配的过程：
        // 开辟堆内存1保存"Hello" -> str指向内存1 -> 开辟堆内存2保存"World" -> 开辟堆内存3保存"HelloWorld" -> str指向内存3
        // 这段代码执行完成后，没有引用指向内存1和内存2，内存1和内存2变成垃圾
        // 所以
        // String的内容不要过多的频繁修改，否则会产生大量的垃圾
    }
}
