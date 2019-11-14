package reflect;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldTest {
    @Test
    /**
     * 测试公有属性
     */
    public void demo1() {
        try {
            // 获得Class
            Class cls = Class.forName("reflect.Person");
            Person person = (Person)cls.getConstructor(String.class, String.class).newInstance("李四", "男");
            // 获得属性
            Field field = cls.getField("country");
            // 操作属性
            field.set(person, "中国");
            String country = (String)field.get(person);
            System.out.println(country);
            System.out.println(person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 测试私有属性
     */
    public void demo2() {
        try {
            // 获得Class
            Class cls = Class.forName("reflect.Person");
            Person person = (Person) cls.newInstance();
            // 获取私有属性
            Field nameField = cls.getDeclaredField("name");
            Field sexField = cls.getDeclaredField("sex");
            // 操作属性，私有属性需要设置访问权限
            // 设置访问权限
            nameField.setAccessible(true);
            sexField.setAccessible(true);
            // 设置属性
            nameField.set(person, "张三");
            sexField.set(person, "男");

            System.out.println(nameField.get(person));
            System.out.println(sexField.get(person));
            System.out.println(person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
