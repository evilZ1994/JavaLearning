package BaseKnowledge.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        // 调用普通方法
        Class<?> cls = Class.forName("BaseKnowledge.Reflect.Book2");
        // Class类中提供有调用普通方法的方法：
        // 1. 取得全部方法： public Method[] getMethods() throws SecurityException
        // 2. 取得指定方法名称和参数的方法： public Method getMethod(BaseKnowledge.String name, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
        // 以上的两个方法返回的是"java.lang.reflect.Method"类的对象
        // 这个类提供了一个方法：
        // public BaseKnowledge.Object invoke(BaseKnowledge.Object obj, BaseKnowledge.Object... args) throws ......
        Object obj = cls.newInstance();
        Method set = cls.getMethod("setTitle", String.class);
        Method get = cls.getMethod("getTitle");
        set.invoke(obj, "Java开发");
        System.out.println(get.invoke(obj));

        // 调用成员
        // 类中的属性一定要在本类实例化对象产生之后才可以分配内存空间
        // 在Class类里面提供有取得成员的方法
        // 1. 取得全部成员： public Field[] getDeclaredFields() throws SecurityException
        // 2. 取得指定成员： public Field getDeclaredField(BaseKnowledge.String name) throws NoSuchFieldException, SecurityException
        // 返回的类型是"java.lang.reflect.Field"类的对象
        // 这个类有两个重要的方法：
        // 1. 取得属性内容： public BaseKnowledge.Object get(BaseKnowledge.Object obj) throws ....
        // 2. 设置属性内容： public BaseKnowledge.Object set(BaseKnowledge.Object obj, BaseKnowledge.Object value) throws ....
        Field titleField = cls.getDeclaredField("title");
        // titleField.set(obj, "Python开发");
        // 报错，不能访问私有成员：java.lang.IllegalAccessException: Class BaseKnowledge.Reflect.Demo3 can not access a member of class BaseKnowledge.Reflect.Book2 with modifiers "private"

        // 在java.lang.reflect.AccessibleObject类下面（JDK1.8之后修改）：
        // 1. Executable: 下面继续继承了Constructor, Method
        // 2. Field
        // 这个类中提供有一个方法：public void setAccessible(boolean flag) throws SecurityException
        // 表示设置是否取消封装
        titleField.setAccessible(true);
        titleField.set(obj, "Python开发"); // 设置成功
        System.out.println(titleField.get(obj));
    }
}

class Book2 {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
