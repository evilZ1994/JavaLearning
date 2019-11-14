package DataStructure.LinearStructure.Search;

public class LinearSearch {
    public static void main(String[] args) {
        // 线性查找

        int[] arr = new int[] {2, 3, 5, 1, 4, 6, 8, 9};
        // 查找目标
        int target = 8;
        // 目标下标
        int index = -1;
        // 遍历
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }
        System.out.println(index);
    }
}
