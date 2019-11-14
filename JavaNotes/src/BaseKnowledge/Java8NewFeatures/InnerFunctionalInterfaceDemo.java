package BaseKnowledge.Java8NewFeatures;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InnerFunctionalInterfaceDemo {
    public static void main(String[] args) {
        // 内建函数式接口
        // java.util.function 提供了四个核心接口
        // 1. 功能性接口 Function<T, R>
        // public interface Function<T, R> {public R apply(T t);}
        // 此接口接收一个参数，并且有一个返回值
        // 2. 消费型接口 Consumer<T>
        // public interface Consumer<T> {pubic void accept(T t);}
        // 此接口接收一个参数，不返回值
        // 3. 供给型接口 Supplier<T>
        // public interface Supplier<T> {public T get();}
        // 此接口不接收参数，有返回值
        // 4. 断言型接口 Predicate<T>
        // public interface Predicate<T> {public boolean test(T t);}
        // 进行判读操作时使用

        // 由于在JDK1.8中存在有以上的四个功能型接口，所以一般很少会由用户去自定义函数式接口

        // 函数式接口示例
        Function<String, Boolean> fun = "##hello" :: startsWith;
        System.out.println(fun.apply("##"));

        Consumer<String> cons = System.out :: println;
        cons.accept("Hello World");

        Supplier<String> supp = "hello" :: toUpperCase;
        System.out.println(supp.get());

        Predicate<String> pre = "Hello" :: equalsIgnoreCase;
        System.out.println(pre.test("hello"));
    }
}
