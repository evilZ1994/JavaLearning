package DataStructure.Sort.Select;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(15, 0, 100);
        System.out.println(Arrays.toString(arr));

        // 堆排序
        heapSort(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr, int end) {
        if (end < 1) {
            return;
        }
        // 找到堆中最后一个顶点位置，从后往前遍历每一个有子节点的顶点
        for (int i = (end - 1) / 2; i >= 0; i--) {
            // 左子节点的位置
            int left = i*2 + 1;
            // 右子节点的位置
            int right = i*2 + 2;
            // 将子树的最大数交换到顶点处
            if (right <= end && arr[right] > arr[i]) {
                int temp = arr[right];
                arr[right] = arr[i];
                arr[i] = temp;
            }
            if (left <= end && arr[left] > arr[i]) {
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
            }
        }
        // 交换顶点和最后一个节点
        int temp = arr[0];
        arr[0] = arr[end];
        arr[end] = temp;
        // 此时最后一个节点的值为当前堆中最大，继续处理前面的节点
        heapSort(arr, end-1);
    }
}
