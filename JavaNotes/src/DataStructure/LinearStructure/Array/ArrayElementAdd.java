package DataStructure.LinearStructure.Array;

import java.util.Arrays;

public class ArrayElementAdd {
    public static void main(String[] args) {
        // 数组元素添加

        // 解决数组的长度不可变的问题
        int[] arr = new int[] {9, 8, 7};
        // 快速查看数组元素
        System.out.println(Arrays.toString(arr));
        // 要加入数组的目标元素
        int dst = 6;

        // 创建一个新数组，长度为原数组长度+1
        int[] newArr = new int[arr.length + 1];
        // 把原数组中的数据复制到新数组
        for (int i=0; i<arr.length; i++) {
            newArr[i] = arr[i];
        }
        // 把目标元素放入新数组的最后
        newArr[arr.length] = dst;
        // 新数组替换原数组
        arr = newArr;
        System.out.println(Arrays.toString(arr));
    }
}
