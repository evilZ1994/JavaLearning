package BaseKnowledge.Array;

import java.util.Arrays;

public class ArrayDemo3 {
    public static void main(String[] args) {
        // Java提供了一些操作数组的类库
        // 数组拷贝
        // BaseKnowledge.System.arraycopy(源数组，源数组拷贝起点，目标数组，目标数组接收起点，拷贝个数)
        int [] dataA = new int[] {1, 2, 3, 4, 5};
        int [] dataB = new int[] {6, 7, 8, 9, 10};
        System.arraycopy(dataA, 2, dataB, 3, 2);
        for (int i : dataB) {
            System.out.print(i + " "); // 输出 6 7 8 3 4
        }
        System.out.println();

        // 数组排序
        // Arrays.sort(arr) / Arrays.sort(arr, from, to) / Arrays.sort(arr, from, to, comparator)
        int [] dataC = new int[] {5, 2, 3, 4, 1};
        Arrays.sort(dataC);
        for (int i : dataC) {
            System.out.print(i + " ");
        }
    }
}
