package BaseKnowledge.Exception;

public class Demo3 {
    public static void main(String[] args) {
        // Runtime类
        int temp = Integer.parseInt("100");
        // parseInt 方法定义：
        // public static int parseInt(BaseKnowledge.String s) throws NumberFormatException
        // parseInt方法抛出了异常，但是却不需要在调用时捕获
        // 原因是Java里面为了方便用户编写代码，专门提供了一种RuntimeException类，程序在编译的时候不会强制要求用户处理异常，
        // 用户可以根据自己的需要选择性的处理，如果用户没有处理，产生异常后将交给JVM处理
        // NumberFormatException是RuntimeException的子类

        // 面试题：
        // 解释Exception与RuntimeException的区别？请列举几个常见的RuntimeException
        // 使用Exception定义的异常必须要被处理，而RuntimeException的异常可以选择性处理
        // 常见RuntimeException：ArithmeticException, NullPointerException, ClassCastException
    }
}
