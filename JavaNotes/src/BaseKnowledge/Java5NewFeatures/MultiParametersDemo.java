package BaseKnowledge.Java5NewFeatures;

/**
 * Java5新特性：可变参数
 */
public class MultiParametersDemo {
    public static void main(String[] args) {
        System.out.println(add(new int[]{1, 2, 3}));
        // 可变参数实现
        System.out.println(add2(1, 2, 3));
    }

    /**
     * 实现多个整形数据的相加操作
     * @param data 由数组接收多个整形数据
     * @return 多个整形数据的累加结果
     */
    public static int add(int[] data) {
        int sum = 0;
        for (int x=0; x<data.length; x++) {
            sum += data[x];
        }
        return sum;
    }

    /**
     * 用可变参数特性实现多个整形数据相加
     * @param data 可变参数相当于一个数组
     * @return 累加结果
     */
    public static int add2(int ... data) {
        int sum = 0;
        for (int x=0; x<data.length; x++) {
            sum += data[x];
        }
        return sum;
    }
}
