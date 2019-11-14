package Thread.demo04;

/**
 * 题目：判断打印的是"one"还是"two"
 * 1. 两个普通同步方法，两个线程，标注打印，打印：one two
 * 2. 新增 Thread.sleep() 给 getOne()，打印：one two
 * 3. 新增普通方法 getThree()，打印：three one two
 * 4. 两个普通同步方法，两个Number对象，打印：two one
 * 5. 修改 getOne() 为静态同步方法，一个Number对象，打印：two one
 * 6. 修改 两个方法均为静态同步方法，一个Number对象，打印：one two
 * 7. 一个静态同步方法，一个非静态同步方法，两个Number对象，打印：two one
 * 8. 两个方法均为静态同步方法，两个Number对象，打印：one two
 */
public class Thread8Monitor {
    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();

        new Thread(() -> number.getOne()).start();
//        new Thread(number::getOne).start();
//        new Thread(number::getTwo).start();
//        new Thread(number2::getTwo).start();
        new Thread(() -> number2.getTwo()).start();
//        new Thread(number2::getTwo).start();
//        new Thread(number::getThree).start();
    }
}

class Number {
    public static synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree() {
        System.out.println("Three");
    }
}