package DataStructure.Sort.Select;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(15, 0, 100);
        System.out.println(Arrays.toString(arr));

        // 选择排序
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        // 每次遍历将最小数放到前面
        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            // 寻找i之后的最小数
            for (int j=i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小数与i交换
            int min = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
