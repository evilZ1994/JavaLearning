package BaseKnowledge.Generic;

public class GenericDemo1 {
    public static void main(String[] args) {
        // 泛型

        // 示例：
        // 要求定义一个表示坐标的操作类（Point），要求保存一下几种坐标
        // 保存数字：x=10, y=20
        // 保存小数：x=10.2, y=20.3
        // 保存字符串：x=东经20度, y=北纬15度

        // 首先可以想到用Object来保存
        Point p = new Point();
        // 设置数据
        p.setX(10);
        p.setY(20);
        // 取出数据
        int x = (Integer)p.getX();
        int y = (Integer)p.getY();
        System.out.println("x:" + x + ", y:" + y);
        // Object引发的问题：
        Point p2 = new Point();
        p.setX(10);
        p.setY("北纬20度");
        // 取出数据
        int x2 = (Integer)p2.getX();
        int y2 = (Integer)p2.getY(); // 存入的是String类型，会出现类型转换异常
        System.out.println("x:" + x2 + ", y:" + y2);
        // 向下转型是一件非常不安全的操作

        // 泛型：类在定义时，可以使用一个标记，这个标记表示类中属性或方法参数的类型标记，在使用的时候才动态设置类型
        // 用泛型实现
        // 使用时设置泛型的类型，注意只能使用引用数据类型，不能使用基本数据类型
        GenericPoint<Integer> gp = new GenericPoint<>();
        gp.setX(10);
        gp.setY(20);
        // 取值时避免了向下转换
        System.out.println("x:" + gp.getX() + " y:" + gp.getY());
    }
}

class Point {
    private Object x;
    private Object y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }
}

// 泛型
// 此时设置的T在类定义上只表示一个标记，在使用的时候为其设置具体的类型
class GenericPoint<T> { // 定义坐标，Type = T，是一个类型
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
