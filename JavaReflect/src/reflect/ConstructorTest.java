package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class ConstructorTest {
    @Test
    /**
     * 获得无参数的构造方法
     */
    public void demo1() {
        try {
            // 获得类的字节码文件对应的Class对象
            Class cls = Class.forName("reflect.Person");
            Constructor constructor = cls.getConstructor();
            Person person = (Person)constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 获得有参数的构造方法
     */
    public void demo2() {
        try {
            Class cls = Class.forName("reflect.Person");
            Constructor constructor = cls.getConstructor(String.class, String.class);
            Person person = (Person)constructor.newInstance("张三", "男");
            System.out.println(person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
