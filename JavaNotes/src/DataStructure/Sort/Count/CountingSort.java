package DataStructure.Sort.Count;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(15, 0, 100);
        System.out.println(Arrays.toString(arr));

        // 计数排序
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 计数排序
     */
    public static void countingSort(int[] arr) {
        // 最大值和最小值 可以确定这个数组的值的范围
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int v : arr) {
            if (v > max) {
                max = v;
            }
            if (v < min) {
                min = v;
            }
        }
        // 统计每个数出现的次数
        int[] counts = new int[max - min + 1];
        for (int v : arr) {
            counts[v - min]++;
        }
        // 将统计后的数值填充到原数组中
        int index = 0;
        for (int i=0; i<counts.length; i++) {
            while (counts[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }
}
