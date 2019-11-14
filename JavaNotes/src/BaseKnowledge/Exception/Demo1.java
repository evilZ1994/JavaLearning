package BaseKnowledge.Exception;

public class Demo1 {
    public static void main(String[] args) {
        // 异常

        // 异常的产生：
        // 异常是导致程序中断执行的一种指令流

        // 异常处理
        // try ... catch ... finally
        try {
            System.out.println("by zero:" + 10/0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("不管是否出现异常，都执行");
        }
        // 一个try语句后面可以跟多个catch语句
        try {
            int x = Integer.valueOf(args[0]);
            int y = Integer.valueOf(args[1]);
            System.out.println("除法计算：" + x/y);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }

        // Throwable的两个直接子类:Error和Exception
        // Error和Exception的区别:
        // Error: 指的是JVM错误，即：此时的程序还没有执行，如果没有执行用户无法处理
        // BaseKnowledge.Exception：指的是程序运行中产生的异常，用户可以处理

        // 程序中出现异常后，JVM自动根据异常的类型产生对应的异常实例
        // 产生异常对象后会判断当前语句上是否存在异常处理，如果没有则交给JVM处理
        // 如果存在异常捕获语句，则使用当前catch语句来进行处理，如果不匹配，则继续匹配下一个catch

        // 直接使用Exception处理
        try {
            // 省略
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 1. 在编写多个catch语句时，异常捕获范围大的异常一定要放在捕获范围小的异常后面
        // 2. 虽然直接使用Exception比较简单，但是所有的异常都会按照同样的方式处理，要求严格的项目中，分开捕获更好

        // throws关键字
        // throws关键字主要用于方法声明上，指的是当方法之中出现异常后交由被调用处来处理
        try {
            System.out.println(MyMath.div(10, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果主方法上继续用throws抛出异常，那么这个异常就将交给JVM处理，打印异常信息，而后结束程序调用

        // throw关键字
        // 程序中可以用throw关键字手动抛出一个异常
        try {
            throw new Exception("自己定义的异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyMath {
    // 由于存在throws，表示此方法的异常交由被调用处处理
    public static int div(int x, int y) throws Exception {
        return x/y;
    }
}
