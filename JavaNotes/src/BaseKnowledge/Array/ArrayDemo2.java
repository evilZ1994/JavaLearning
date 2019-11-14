package BaseKnowledge.Array;

public class ArrayDemo2 {
    public static void main(String[] args) {
        // 数组与方法的引用操作
        int data[] = new int[]{1, 2, 3};
        // 传递了数组的引用，对数组的修改会影响到原始数组
        change(data);
        for (int d : data) {
            // 输出 2，4，6
            System.out.println(d);
        }
    }

    private static void change(int temp[]) {
        for (int i=0; i<temp.length; i++) {
            temp[i] *= 2;
        }
    }
}
