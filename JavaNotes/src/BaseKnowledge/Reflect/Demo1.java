package BaseKnowledge.Reflect;

import java.util.Date;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 反射机制
        // 认识反射：
        // 首先正常情况下，"正"就是先有类，然后产生对象
        Date date = new Date();
        System.out.println(date);
        // 而"反"就是指可以利用对象找到对象的出处，在Object类里面提供有一个方法：
        // - 取得Class对象：public final Class<?> getClass()

        // 观察反射：
        System.out.println(date.getClass()); // class java.util.Date

        // Class类对象实例化
        // java.lang.Class是一个类，是反射操作的源头。即：所有的反射都要从此类开始进行
        // 这个类有三种实例化方式：
        // 1. 调用Object类的getClass()方法 （用的最少）
        Class<?> cls = date.getClass();
        // 2. 使用"类.class"取得 (用的较多)
        Class<?> cls2 = Date.class;
        // 3. 调用Class类提供的方法：public static Class<?> forName(BaseKnowledge.String className) throws ClassNotFoundException
        // (用的最多）
        Class<?> cls3 = Class.forName("java.util.Date");

        // 反射实例化对象
        // 当实例化一个对象时，通常使用关键字new 进行对象的实例化。
        // 但是如果有了Class类对象，就可以利用反射来实现对象实例化操作
        // public T newInstance() throws InstantiationException, IllegalAccessException
        Object date1 = cls3.newInstance();
        Date date2 = (Date)cls3.newInstance();

        // new关键字容易引起耦合问题
        // 如之前的工厂模式（BaseKnowledge.Interface.FactoryDemo）
        // 如果要增加子类的话，工厂类要被一直修改

        // 新工厂模式如下：
        // 新增子类时，只需要传入新子类的类名即可，工厂类不用修改
        Fruit apple = Factory.getInstance("BaseKnowledge.Reflect.Apple");
        apple.eat();
        // 实现了解耦合
    }
}

interface Fruit {
    public void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("Eat Apple");
    }
}

class Factory {
    public static Fruit getInstance(String className) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(className).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return f;
    }
}
