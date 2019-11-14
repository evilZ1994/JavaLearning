package DataStructure.Sort;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(15, 0, 1000);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        // 基数排序
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        // 基数排序 队列实现
        radixSort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 基数排序
     */
    public static void radixSort(int[] arr) {
        // 寻找最大值
        int max = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v > max) {
                max = v;
            }
        }
        // 最大值的位数
        int maxLength = String.valueOf(max).length();
        // 二维数组保存每个基数对应的值
        int[][] temp = new int[10][arr.length];
        // 记录每个基数的值的个数
        int[] number = new int[10];
        for (int i=0, m=1; i<maxLength; i++, m*=10) {
            for (int v : arr) {
                // 基数，取个，百..位上的值
                int n = (v / m) % 10;
                temp[n][number[n]] = v;
                number[n] += 1;
            }
            // 将按基数分组后的数依次取出，填入arr数组中
            int index = 0;
            for (int j=0; j<temp.length; j++) {
                for (int k=0; k<number[j]; k++) {
                    arr[index++] = temp[j][k];
                }
                // 将个数重置为0
                number[j] = 0;
            }
        }
    }

    /**
     * 基数排序 队列实现
     * @param arr
     */
    public static void radixSort2(int[] arr) {
        // 寻找最大值
        int max = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v > max) {
                max = v;
            }
        }
        // 最大值的位数
        int maxLength = String.valueOf(max).length();
        // 用队列保存每个基数对应的值
        Queue<Integer>[] temp = new LinkedBlockingQueue[10];
        for (int i=0; i<temp.length; i++) {
            temp[i] = new LinkedBlockingQueue<Integer>();
        }
        for (int i=0, m=1; i<maxLength; i++, m*=10) {
            for (int v : arr) {
                // 基数，取个，百..位上的值
                int n = (v / m) % 10;
                temp[n].add(v);
            }
            // 将按基数分组后的数依次取出，填入arr数组中
            int index = 0;
            for (Queue<Integer> queue : temp) {
                while (!queue.isEmpty()) {
                    arr[index++] = queue.poll();
                }
            }
        }
    }
}
