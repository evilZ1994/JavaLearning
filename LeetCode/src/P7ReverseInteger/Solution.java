package P7ReverseInteger;

/**
 * 题目描述：
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

public class Solution {

    public static void main(String[] args) {
        int x = -223;
        int y = 2147483647;
        System.out.println(Integer.compare(y, Integer.MAX_VALUE));
    }

    public int reverse(int x) {
        int y = 0;
        while (x != 0) {
            // Integer.MAX_VALUE: 2147483647
            // Integer.MIN_VALUE: -2147483648
            // Integer比较时，如果Integer的值在[-128,127]时，都会从常量池中取, 比较时用==会返回true。在这个范围外的话用Integer.compare(x,y)函数
            if (y > Integer.MAX_VALUE/10 || y < Integer.MIN_VALUE/10) {
                return 0;
            }
            int temp = x%10;
            if (Integer.compare(y, Integer.MAX_VALUE) == 0 && temp > 7) {
                return 0;
            } else if (Integer.compare(y, Integer.MIN_VALUE) == 0 && temp < -8) {
                return 0;
            }
            x = x/10;
            y = (y * 10) + temp;
        }
        return y;
    }
}
