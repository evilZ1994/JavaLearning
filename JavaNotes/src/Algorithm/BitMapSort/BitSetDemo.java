package Algorithm.BitMapSort;

import java.util.BitSet;

public class BitSetDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{98, 82, 1, 34, 23, 34, 80, 23, 82, 98, 12};
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.size());
        for (int i : arr) {
            bitSet.set(i);
        }
        // 去重后的元素个数
        System.out.println(bitSet.cardinality());
        // 升序
        for (int i=bitSet.nextSetBit(0); i >=0 ; i=bitSet.nextSetBit(i+1)) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 降序
        for (int i=bitSet.previousSetBit(bitSet.size()-1); i>=0; i=bitSet.previousSetBit(i-1)) {
            System.out.print(i + " ");
        }
    }
}
