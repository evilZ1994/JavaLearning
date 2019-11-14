package DataStructure.Sort.Insert;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(10, 0, 100);
        System.out.println(Arrays.toString(arr));

        // 插入排序
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int temp = arr[i];
            int j=i-1;
            for (; j>=0 && arr[j]>temp; j--) {
                // 如果前面的数大于第i个数，则依次往后挪
                arr[j+1] = arr[j];
            }
            // 遇到小于第i个数的数了，第i个数就放在这个数后面
            arr[j+1] = temp;
        }
    }
}
