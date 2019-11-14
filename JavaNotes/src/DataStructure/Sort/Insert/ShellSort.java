package DataStructure.Sort.Insert;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(5000, 0, 10000);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        // 希尔排序
        long start = System.currentTimeMillis();
        shellSort(arr);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(arr));

        start = System.currentTimeMillis();
        shellSort2(arr2);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(arr2));
    }


    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr) {
        for (int step=arr.length/2; step>0; step/=2) {
            for (int i=step; i<arr.length; i++) {
                int temp = arr[i];
                int j=i-step;
                for (; j>=0 && arr[i]>temp; j-=step) {
                    arr[j+step] = arr[j];
                }
                arr[j+step] = temp;
            }
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort2(int[] arr) {
        for (int step=arr.length/2; step>0; step/=2) {
            for (int i=0; i<step; i++) {
                for (int j=i+step; j<arr.length; j+=step) {
                    int temp = arr[j];
                    int k = j-step;
                    for (; k>=0 && arr[k]>temp; k-=step) {
                        arr[k+step] = arr[k];
                    }
                    arr[k+step] = temp;
                }
            }
        }
    }
}
