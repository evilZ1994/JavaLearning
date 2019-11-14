package BaseKnowledge.Generic;

public class GenericDemo4 {
    public static void main(String[] args) {
        // 泛型方法
        // 泛型方法不一定非要定义在支持泛型的类里面

        String str = fun("Hello");
    }

    /**
     * 泛型方法
     * @param t
     * @param <T> T的类型由传入的参数类型决定
     * @return
     */
    public static <T> T fun(T t) {
        System.out.println(t);
        return t;
    }
}
