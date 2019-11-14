package P4MedianOfTwoSortedArrays;

/**
 * 寻找两个有序数组的中位数
 *
 * 题目描述：
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[0];
        int [] nums2 = new int[] {1};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 思路比较简单
        // 从两个矩阵的左右往中间遍历，
        // 左边比较两个数组的最小值，值最小的那个数组的左下标加1，记录最小值
        // 右边比较两个数组的最大值，值最大的数组的右下标减1，记录最大值
        // 返回（最大值+最小值）/2

        int s1 = 0;  // 记录nums1的开始下标
        int s2 = 0;  // 记录nums2的开始下标
        int e1 = nums1.length - 1;  // 记录nums1的尾部下标
        int e2 = nums2.length - 1;  // 记录nums2的尾部下标
        int min = 0;
        int max = 0;
        while (s1 <= e1 || s2 <= e2) {
            if (s1 > e1) {
                min = nums2[s2];
                s2 += 1;
            } else if (s2 > e2) {
                min = nums1[s1];
                s1 += 1;
            } else if (nums1[s1] > nums2[s2]) {
                min = nums2[s2];
                s2 += 1;
            } else {
                min = nums1[s1];
                s1 += 1;
            }
            if (e2 < 0) {
                max = nums1[e1];
                e1 -= 1;
            } else if (e1 < 0) {
                max = nums2[e2];
                e2 -= 1;
            } else if (nums1[e1] > nums2[e2]) {
                max = nums1[e1];
                e1 -= 1;
            } else {
                max = nums2[e2];
                e2 -= 1;
            }
        }
        return (double)(min + max) / 2;
    }
}
