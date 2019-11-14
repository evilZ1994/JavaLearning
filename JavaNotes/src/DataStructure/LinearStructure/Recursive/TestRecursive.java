package DataStructure.LinearStructure.Recursive;

public class TestRecursive {
    // 递归
    public static void main(String[] args) {
         print(10);
    }

    // 简单递归
    public static void print(int i) {
        if (i>0) {
            System.out.println(i);
            print(i - 1);
        }
    }
}
