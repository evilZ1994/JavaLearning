package reflect;

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodTest {
    @Test
    /**
     * 测试公有方法
     */
    public void demo1() {
        try {
            Class cls = Class.forName("reflect.Person");
            Person person = (Person)cls.newInstance();
            // 获得公有方法
            Method nameMethod = cls.getMethod("setName", String.class);
            Method sexMethod = cls.getMethod("setSex", String.class);
            // 执行方法
            nameMethod.invoke(person, "张三");
            sexMethod.invoke(person, "男");

            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 测试私有方法
     */
    public void demo2() {
        try {
            Class cls = Class.forName("reflect.Person");
            Person person = (Person) cls.newInstance();
            // 获得私有方法
            Method method = cls.getDeclaredMethod("fun");
            // 设置访问权限
            method.setAccessible(true);
            // 执行私有方法
            method.invoke(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
