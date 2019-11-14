package DataStructure.LinearStructure.Array;

import java.util.Arrays;

public class ArrayElementDelete {
    public static void main(String[] args) {
        // 数组元素删除

        int[] arr = new int[] {1, 3, 4, 5, 8};
        // 要删除的元素的下标
        int dst = 3;

        // 创建一个新的数组，长度是原数组的长度-1
        int[] newArr = new int[arr.length - 1];
        // 复制原数组中除要删除的元素以外的其他元素
        for (int i=0; i<newArr.length; i++) {
            if (i < 3) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = arr[i + 1];
            }
        }
        // 新数组替换原数组
        arr = newArr;
        System.out.println(Arrays.toString(arr));
    }
}
