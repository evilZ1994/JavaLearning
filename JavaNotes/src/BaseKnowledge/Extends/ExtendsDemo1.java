package BaseKnowledge.Extends;

public class ExtendsDemo1 {
    public static void main(String[] args) {
        Student stu = new Student("Tom", 24, "New East");
        System.out.println(stu.getName()+stu.getAge()+stu.getSchool());
        // 继承的限制
        // 1. Java不允许多继承
        // 一个子类不能同时继承多个父类（C++支持）
        // 2. 子类在继承父类时，严格来讲会继承父类的所有操作，对于私有操作属于隐式继承，对于非私有操作属于显式继承
        // 在子类中不能访问父类的私有属性，只能被间接操作。
        // 3. 在子类对象构造之前一定会默认调用父类的构造（默认使用无参构造），以保证父类对象先实例化，然后再实例化子类对象。
        // 如果父类中有无参构造时，子类的构造方法中可加可不加super()
        // 如果父类中没有无参构造时，子类的构造方法中必须加上与父类构造方法对应的super(BaseKnowledge.Object param)
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person {
    private String school;

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
