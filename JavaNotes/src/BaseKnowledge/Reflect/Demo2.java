package BaseKnowledge.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 调用构造方法
        Class<?> cls = Class.forName("BaseKnowledge.Reflect.Book");
//        BaseKnowledge.Object obj = cls.newInstance();
//        BaseKnowledge.System.out.println(obj);
        // 报错：java.lang.NoSuchMethodException: BaseKnowledge.Reflect.Book.<init>()
        // 因为当前的Book类没有无参构造方法。
        // 只能明确调用有参构造方法

        // Class类里提供有取得构造方法的方法：
        // 1. 取得全部构造：public Constructor<?>[] getConstructors() throws SecurityException
        // 2. 取得一个指定参数顺序的构造：public Constructor<T> getConstructor(Class<?>...parameterTypes) throws NoSuchMethodException, SecurityException
        // 以上两个方法都是返回"java.lang.reflect.Constructor"类的对象
        // 这个类中提供有一个实例化对象的方法：
        // public T newInstance(BaseKnowledge.Object...initargs) throws InstantiationException....

        // 明确调用类中的有参构造：
        Constructor<?> constructor = cls.getConstructor(String.class, double.class);
        Object obj = constructor.newInstance("Java开发", 80);
        System.out.println(obj);

        // 所以注意：在普通Java类中，不管提供多少个构造方法，至少要保留无参构造。
    }
}

class Book {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book Name: " + this.title + ", Price: " + this.price;
    }
}
