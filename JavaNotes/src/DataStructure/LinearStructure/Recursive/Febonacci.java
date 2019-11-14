package DataStructure.LinearStructure.Recursive;

public class Febonacci {
    public static void main(String[] args) {
        // 斐波那契数列
        System.out.println(febonacci(10));
    }

    // Febonacci斐波那契数列
    // 返回斐波那契数列的第i项
    public static int febonacci(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        return febonacci(i-1) + febonacci(i-2);
    }

}
