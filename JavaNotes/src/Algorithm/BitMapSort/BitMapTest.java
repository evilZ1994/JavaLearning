package Algorithm.BitMapSort;

import DataStructure.Sort.ArrayUtil;

import java.util.Arrays;

public class BitMapTest {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.genArray(20, 0, 5000);
        System.out.println(Arrays.toString(arr));
        bitMapSort(arr);
    }

    static void bitMapSort(int[] arr) {
        // 找出最大数
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        // 定义byte数组
        byte[] bytes = new byte[max / 8 + 1];
        for (int a : arr) {
            int byteIndex = a / 8;
            int innerIndex = a % 8;
            // 将1左移innerIndex位，那么innerIndex位置为1，其他位为0
            // 然后与byte值进行或运算，将innerIndex位设置为1
            bytes[byteIndex] = (byte) (bytes[byteIndex] | 1 << innerIndex);
        }
        // 打印排序后的数组
        for (int i=0; i<bytes.length; i++) {
            for (int j=0; j<8; j++) {
                if ((bytes[i] & 1 << j) != 0) {
                    System.out.print((i * 8 + j) + " ");
                }
            }
        }
    }
}
