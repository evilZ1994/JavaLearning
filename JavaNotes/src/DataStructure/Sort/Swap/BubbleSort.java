package DataStructure.Sort.Swap;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;

/**
 * 冒泡排序示例
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(50, 0, 100);

        System.out.println(Arrays.toString(arr));
        // 冒泡排序
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        // 冒泡排序
        // 每次循环时，比较最大数，将最大数往后交换
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
