package DataStructure.Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(15, 0, 100);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        // 归并排序
        mergeSort(arr, 0, arr.length/2, arr.length);
        System.out.println(Arrays.toString(arr));

        int[] result = mergeSort2(arr2);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr, int left, int mid, int right) {
        if (left == right - 1) {
            return;
        }
        mergeSort(arr, left, left + (mid - left)/2, mid);
        mergeSort(arr, mid, mid + (right - mid)/2, right);
        int[] result = new int[right - left];
        int i = left, j = mid;
        while (i < mid || j < right) {
            int index = i - left + j - mid;
            if (j == right || (i < mid && arr[i] < arr[j])) {
                result[index] = arr[i++];
            } else if (i == mid || (j < right && arr[i] > arr[j])){
                result[index] = arr[j++];
            } else {
                result[index] = arr[i++];
                result[index+1] = arr[j++];
            }
        }
        for (int k=0; k<result.length; k++) {
            arr[k + left] = result[k];
        }
    }

    /**
     * 归并排序
     */
    public static int[] mergeSort2(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length - arr.length/2];
        for (int i=0; i<left.length; i++) {
            left[i] = arr[i];
        }
        for (int i=0; i<right.length; i++) {
            right[i] = arr[i+arr.length/2];
        }
        left = mergeSort2(left);
        right = mergeSort2(right);
        int[] result = new int[arr.length];
        int i = 0,j = 0;
        while (i<left.length && j<right.length) {
            if (left[i] < right[j]) {
                result[i+j] = left[i];
                i++;
            } else {
                result[i+j] = right[j];
                j++;
            }
        }
        while (i < left.length) {
            result[i+j] = left[i];
            i++;
        }
        while (j < right.length) {
            result[i+j] = right[j];
            j++;
        }
        return result;
    }
}
