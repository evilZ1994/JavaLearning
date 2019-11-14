package BaseKnowledge.Comparator;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        // Arrays类
        // Arrays类就是java.util.Arrays，一个工具类
        // 主要完成所有与数组有关的操作

        // 数组排序：
        // public static void sort(数据类型[] a)
        // public static void sort(数据类型[] a, int fromIndex, int toIndex)
        // public static void sort(T[] a, BaseKnowledge.Comparator<? super T> c)
        // public static void sort(BaseKnowledge.Object[] a)

        // 二分查找：public static int binarySearch(数据类型[] a, 数据类型 key)
        // 二分查找有个前提，数组必须是排序后的结果
        int data[] = new int[] {1, 2, 12, 9, 4, 7, 20, 8, 15};
        System.out.println(Arrays.binarySearch(data, 8));  // -7 结果不准确
        Arrays.sort(data);  // 进行排序
        System.out.println(Arrays.binarySearch(data, 8));  // 4

        // 数组比较：public static boolean equals(数据类型[] a, 数据类型[] a2)
        int dataA[] = new int[] {1, 2, 3};
        int dataB[] = new int[] {1, 2, 3};
        int dataC[] = new int[] {3, 2, 1};
        System.out.println(Arrays.equals(dataA, dataB));  // true
        System.out.println(Arrays.equals(dataA, dataC));  // false  //数组元素顺序也要一致

        // 填充数组：public static void fill(数据类型[] a, 数据类型 val)
        // 以一个指定内容将数组填满
        int[] data1 = new int[10];
        Arrays.fill(data1, 1);
        // 将数组转为字符串：public static BaseKnowledge.String toString(数据类型[] a)
        System.out.println(Arrays.toString(data1));  // [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    }
}
