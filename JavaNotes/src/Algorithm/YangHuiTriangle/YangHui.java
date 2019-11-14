package Algorithm.YangHuiTriangle;

import java.util.Scanner;

/**
 * 杨辉三角：
 * 第n(0<=0)层，对应于二项式(a+b)^n展开式的系数
 * 如n=8时，每一层如下
 *         1
 *        1 1
 *       1 2 1
 *      1 3 3 1
 *     1 4 6 4 1
 *    1 5 10 10 5 1
 *   1 6 15 20 15 6 1
 *  1 7 21 35 35 21 7 1
 * 1 8 28 56 70 56 28 8 1
 */
public class YangHui {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Triangle1(n + 1);
        Triangle2(n + 1);
    }

    /**
     * 解法1：二维数组保存计算结果，第i行第j列 等于 第i-1行第j-1列 + 第i-1行第j列
     */
    static void Triangle1(int n) {
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            arr[i][0] = 1;
            System.out.print(arr[i][0] + " ");
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                System.out.print(arr[i][j] + " ");
            }
            if (i > 0) {
                arr[i][i] = 1;
                System.out.print("1");
            }
            System.out.print("\n");
        }
    }

    /**
     * 解法2：二项式定理
     * C(i, j) = i! / (j!*(i-j)!)
     */
    static void Triangle2(int n) {
        for (int i=0; i<n; i++) {
            int number = 1;
            for (int j=0; j<=i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
