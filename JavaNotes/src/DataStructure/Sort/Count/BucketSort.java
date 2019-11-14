package DataStructure.Sort.Count;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(20, 0, 100);
        System.out.println(Arrays.toString(arr));

        // 桶排序
        bucketSort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 桶排序
     * @param bucketSize 桶的大小
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        // 最大值和最小值用来确定数组的范围
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
        // 桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        // 每个桶涉及到频繁的插入，所以采用LinkedList
        List<Integer>[] buckets = new LinkedList[bucketCount];
        for (int v : arr) {
            // 通过映射函数获取该值对应的桶
            int index = (v - min) / bucketSize;
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<>();
            }
            // 有序放入桶中
            int i=0;
            for (; i<buckets[index].size(); i++) {
                if (v < buckets[index].get(i)) {
                    break;
                }
            }
            buckets[index].add(i, v);
        }
        // 从桶中取出
        int index = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket != null) {
                for (int v : bucket) {
                    arr[index++] = v;
                }
            }
        }
    }
}
