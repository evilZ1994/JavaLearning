package BaseKnowledge.Java8NewFeatures;

public class MethodReference {
    public static void main(String[] args) {
        // 方法引用

        // 方法引用就是为一个方法设置别名

        // 一共有四种形式
        // 1. 引用静态方法： 类名称 :: 静态方法名称
        // 2. 引用某个对象的方法： 实例化对象 :: 普通方法
        // 3. 引用特定类型的方法： 特定类 :: 普通方法
        // 4. 引用构造方法： 类名称 :: new

        // 1.引用静态方法
        // 将String.valueOf()方法变为了IMessage3接口里的transform()方法
        IMessage3<Integer, String> msg = String :: valueOf;
        String str = msg.transform(1000);
        System.out.println(str);

        // 2. 引用对象方法
        // String类的toUpperCase()定义: public BaseKnowledge.String toUpperCase()
        IMessage4<String> msg2 = "hello" :: toUpperCase;
        String str2 = msg2.upper();
        System.out.println(str2);

        // 3. 引用特定类的方法
        IMessage5<String> msg3 = String::compareTo;
        System.out.println(msg3.compare("A", "B"));

        // 4. 引用构造方法
        IMessage6<Book> msg4 = Book :: new;
        Book book = msg4.create("Java开发");
        System.out.println(book.toString());
    }
}

/**
 * 实现方法的引用接口
 * @param <P> 引用方法的参数类型
 * @param <R> 引用方法的返回类型
 */
@FunctionalInterface // 注解意义：函数式接口，只能够定义一个方法
interface IMessage3<P, R> {
    public R transform(P p);
}

/**
 * 引用对象的普通方法
 * @param <R>
 */
@FunctionalInterface
interface IMessage4<R> {
    public R upper();
}

/**
 * 引用特定类的方法
 * @param <P>
 */
@FunctionalInterface
interface IMessage5<P> {
    public int compare(P p1, P p2);
}


class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
/**
 * 构造方法引用示例
 */
@FunctionalInterface
interface IMessage6<C> {
    public C create(String t);
}
