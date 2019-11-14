package DataStructure.Tree.BinaryTree.ArrayStructure;

import DataStructure.Sort.ArrayUtil;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(13, 0, 100);
        ArrayUtil.println(arr);

        heapSort(arr);
        ArrayUtil.println(arr);
    }

    /**
     * 调整为大顶堆
     * @param arr 数组
     * @param size 需要调整的大小
     * @param index 最后一个叶子节点的父节点位置
     */
    public static void maxHeap(int[] arr, int size, int index) {
        // 左节点位置
        int left = index * 2 + 1;
        // 右节点位置
        int right = index * 2 + 2;
        // 记录最大值
        int maxIndex = index;
        // 寻找最大值的节点
        if (left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        // 将最大值交换到当前节点
        if (index != maxIndex) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            // 交换后可能影响到之前的堆
            maxHeap(arr, size, maxIndex);
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        // 将数组调整为大顶堆 (arr.length - 2)/2 为数组中最后一个节点的父节点位置，第n个节点的父节点计算：(n-1)/2
        for (int i=(arr.length - 2) / 2; i>=0; i--) {
            maxHeap(arr, arr.length, i);
        }
        // 交换顶点和待排数组中最后一个节点，然后将最后一个节点隔离后，将剩余数组调整为大顶堆
        for (int i=arr.length-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }
}
