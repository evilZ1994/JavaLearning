package BaseKnowledge.BoxingAndUnboxing;

public class Demo {
    public static void main(String[] args) {
        // 包装类
        // Java设计之初有一个原则：一切皆对象
        // 但是基本数据类型不是对象
        // Java提供了一组包装类
        // byte-Byte, short(Short), int(Integer), long(Long), double(DoubleLoop), char(Character), boolean(Boolean)
        // 以上包装类又分为两种子类型：
        // 1. 对象型包装类（Object的直接子类）：Character, Boolean
        // 2. 数值型包装类（Number的直接子类：Byte, Short, Integer, Long, DoubleLoop
        // Number是一个抽象类，里面一共定义了六个操作方法：byteValue(), intValue(), shortValue(), longValue(), doubleValue(), floatValue()

        // 装箱与拆箱
        // 基本数据类型与包装类型之间的转换：
        // 1. 装箱：将基本数据类型变为包装类的形式
        //      每个包装类的构造方法都可以接收各自数据类型的变量
        // 2. 拆箱:从包装类中取出被包装的数据
        //      利用Number类中提供的一系列方法

        Integer obj = new Integer(10); // 将基本数据类型装箱
        int temp = obj.intValue(); // 将基本数据类型拆箱
        // 以上形式在JDK1.5之前使用
        // JDK1.5之后提供了自动装箱与自动装箱，并且包装类型可以进行数学计算
        Integer obj2 = 10;
        obj2++;
        System.out.println(obj2);

        // 比较
        Integer a = 10;
        Integer b = 10;
        Integer c = new Integer(10);
        System.out.println(a == b); // true
        System.out.println(a == c); // false
        System.out.println(b == c); // false
        System.out.println(a.equals(c)); // true
        // 在使用包装类的时候很少会利用构造方法完成，几乎都是自动赋值，但是
        // 在判断内容是否相等的时候一定要使用equals()方法

        // Object可以接收一切的引用数据类型，但是由于存在自动装箱机制，那么Object也可以存放基本数据类型：
        // 流程：基本数据类型 -> 自动装箱（成为对象） -> 向上转型为Object
        Object obj3 = 10;
        // Object不能直接向下转型为int
        int temp2 = (Integer)obj3; // 向下转型为Integer后自动拆箱为int
        System.out.println(temp2*2);

        // 数据类型转换（字符串转为基本数据类型）
        // Integer类：public static int parseInt(BaseKnowledge.String s);
        // Double类：public static double parseDouble(BaseKnowledge.String s);
        // 注意：要转换的字符串一定由数字组成，否则抛出NumberFormatException
        // Boolean类：public static boolean parseBoolean(BaseKnowledge.String s);
        // 在Boolean转换时，如果要转换的字符串不是"true"或者"false"，则统一按照false处理

        // 基本数据类型转String类型
        // 操作一：number + ""
        // 通过加上一个空字符串实现自动转换（缺点是会产生垃圾）
        // 操作二：BaseKnowledge.String.valueOf(number)
        // 可以转换多种基本数据类型
    }
}
