package QuestionCollection.TwoNumSumOfArray;

import DataStructure.Sort.Swap.QuickSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] line = in.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int i=0; i<line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        // 排序
        QuickSort.quickSort(arr, 0, arr.length - 1);
        // 查找
        System.out.println(getNum(arr, n));
    }

    static String getNum(int[] arr, int n) {
        for (int i=0, j=arr.length-1; i<j;) {
            if (arr[i] + arr[j] == n) {
                return "[" + arr[i] + ", " + arr[j] + "]";
            } else if (arr[i] + arr[j] < n) {
                i++;
            } else {
                j--;
            }
        }
        return "[-1, -1]";
    }
}
