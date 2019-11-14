package DataStructure.LinearStructure.Search;

public class BinarySearch {
    public static void main(String[] args) {
        // 二分查找（必须是有序数组）

        // 目标数组
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 目标元素
        int target = 6;
        // 目标下标
        int index = -1;
        // 记录开始位置
        int begin = 0;
        // 记录结束位置
        int end = arr.length - 1;
        // 记录中间位置
        int mid = (begin + end)/2;
        // 循环查找
        while (true) {
            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (begin >= end) {
                break;
            } else if (arr[mid] > target) {
                // 查找目标在中间元素左侧
                end = mid - 1;
            } else {
                // 查找目标在中间元素右侧
                begin = mid + 1;
            }
            mid = (begin + end)/2;
        }
        System.out.println(index);
    }
}
