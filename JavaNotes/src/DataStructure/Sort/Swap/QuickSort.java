package DataStructure.Sort.Swap;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序示例
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(50, 0, 100);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println(Arrays.toString(arr));
        System.out.println();
        // 快速排序
        // 填坑法
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        // 指针交换法
        quickSort2(arr2, 0, arr2.length-1);
        System.out.println(Arrays.toString(arr2));
        // 非递归法
        quickSort3(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    /**
     * 填坑法
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // 把数组中的开始数字作为标准数
        int standard = arr[start];
        // 记录需要排序的下标
        int low = start;
        int high = end;
        // 循环找比标准数大的数和比标准数小的数
        while (low < high) {
            // 右边的数字比标准数大
            while (low<high && standard<=arr[high]) {
                high--;
            }
            // 使用右边的数字替换左边的数字
            arr[low] = arr[high];
            // 如果左边的数字比标准数小
            while (low<high && standard>=arr[low]) {
                low++;
            }
            // 使用左边的数替换右边的数
            arr[high] = arr[low];
        }
        // 把标准数赋给低和高重合的位置
        arr[low] = standard;
        // 递归
        // 处理所有的小数字
        quickSort(arr, start, low);
        // 处理所有的大数字
        quickSort(arr, low+1, end);
    }

    /**
     * 指针交换法
     */
    public static void quickSort2(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // 开始数字作为标准数
        int standard = arr[start];
        // 记录高低索引
        int low = start;
        int high = end;
        while (low < high) {
            // 右边完全小于标准数的要准备移到左边
            while (low < high && standard <= arr[high]) {
                high--;
            }
            // 左边大于等于标准数的要准备移到右边
            while (low < high && standard > arr[low]) {
                low++;
            }
            // 交换
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        // 处理小的部分
        quickSort2(arr, start, low);
        // 处理大的部分
        quickSort2(arr, low+1, end);
    }

    /**
     * 非递归
     */
    public static void quickSort3(int[] arr) {
        // 用栈记录每一次的操作
        Stack<Map<String, Integer>> stack = new Stack<>();
        // 第一次操作
        Map<String, Integer> firstOp = new HashMap<>();
        firstOp.put("start", 0);
        firstOp.put("end", arr.length-1);
        // 第一次操作入栈
        stack.push(firstOp);
        while (!stack.isEmpty()) {
            // 取出栈中的操作
            Map<String, Integer> op = stack.pop();
            int start = op.get("start");
            int low = start;
            int end = op.get("end");
            int high = end;
            int standard = arr[low];
            // 这里可用"填坑法"或"指针交换法"
            while (low < high) {
                while (low < high && standard <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && standard >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standard;
            // 存入操作数
            if (low > start) {
                Map<String, Integer> leftOp = new HashMap<>();
                leftOp.put("start", start);
                leftOp.put("end", low);
                stack.push(leftOp);
            }
            if (low + 1 < end) {
                Map<String, Integer> rightOp = new HashMap<>();
                rightOp.put("start", low + 1);
                rightOp.put("end", end);
                stack.push(rightOp);
            }
        }
    }
}
