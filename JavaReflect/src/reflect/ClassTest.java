package reflect;

import org.junit.Test;

public class ClassTest {
    @Test
    /**
     * 获得Class对象
     * 1. 类名.class
     * 2. 对象.getClass()
     * 3. Class.forName()
     */
    public void demo1() {
        // 1. 通过 类名.class
        Class cls1 = Person.class;
        // 2. 通过 对象.getClass()
        Person person = new Person();
        Class cls2 = person.getClass();
        // 3. 通过 Class.forName()
        try {
            Class cls3 = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
