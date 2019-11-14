package DataStructure.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 生成随机数组，用于测试排序
 */
public class ArrayUtil {

    public static int[] genArray() {
        return genArray(Math.abs(new Random().nextInt()));
    }

    public static int[] genArray(int length) {
        return genArray(length, 0, Integer.MAX_VALUE);
    }

    public static int[] genArray(int rangeStart, int rangeEnd) {
        return genArray(Math.abs(new Random().nextInt()), rangeStart, rangeEnd);
    }

    public static int[] genArray(int length, int rangeStart, int rangeEnd) {
        int range = rangeEnd - rangeStart;
        int[] arr = new int[length];
        Random random = new Random();
        for (int i=0; i<length; i++) {
            arr[i] = (int)(random.nextFloat() * range) + rangeStart;
        }
        return arr;
    }

    public static void println(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
 }
