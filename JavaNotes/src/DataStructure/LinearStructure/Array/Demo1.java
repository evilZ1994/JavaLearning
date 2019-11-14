package DataStructure.LinearStructure.Array;

public class Demo1 {
    public static void main(String[] args) {
        // 创建数组
        int[] arr1 = new int[3];
        // 获取长度
        int length1 = arr1.length;
        // 访问元素
        int element1 = arr1[0];
        System.out.println(element1);  // int型数组，默认值为0
        // 赋值
        arr1[0] = 99;
        arr1[1] = 98;
        arr1[2] = 97;
        // 数组遍历
        for (int i=0; i<arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        for (int element : arr1) {
            // foreach遍历
            System.out.println(element);
        }
        // 数组初始赋值
        int[] arr2 = new int[] {90, 80, 70, 60};
        System.out.println(arr2.length);
    }
}
